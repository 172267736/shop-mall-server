package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.event.EventTrack;
import cn.shop.mall.admin.model.UserParam;
import cn.shop.mall.admin.service.UserService;
import cn.shop.mall.center.dao.MenuDao;
import cn.shop.mall.center.dao.RoleUserDao;
import cn.shop.mall.center.dao.UserAdminDao;
import cn.shop.mall.center.entity.MenuEntity;
import cn.shop.mall.center.entity.RoleUserEntity;
import cn.shop.mall.center.entity.UserAdminEntity;
import cn.shop.mall.common.enums.CodeMsgEnum;
import cn.shop.mall.common.enums.EventTrackEnum;
import cn.shop.mall.common.enums.MenuTypeEnum;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.model.PageDto;
import cn.shop.mall.common.model.UserBean;
import cn.shop.mall.common.model.UserHeader;
import cn.shop.mall.common.util.MD5Utils;
import cn.shop.mall.common.util.StrUtil;
import cn.shop.mall.common.vo.ResponseVO;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAdminDao userAdminDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleUserDao roleUserDao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final int loginExpireTime = 24;

    private static final String defaultPassword = "123456";

    /**
     * 登录
     */
    @EventTrack(value = EventTrackEnum.客户端登录)
    @Override
    public ResponseVO login(UserParam userParam) {
        UserAdminEntity userEntity = userAdminDao.getByUserName(userParam.getUserName());
        if (userEntity == null) {
            return ResponseVO.FAIL("账号不存在");
        }
        String md5SaltPwd = MD5Utils.getSaltMD5(userParam.getPassword(), userEntity.getSalt());
        if (!md5SaltPwd.equals(userEntity.getUserPassword())) {
            return ResponseVO.FAIL(CodeMsgEnum.账号密码有误);
        }
        List<MenuEntity> menus;
        if (userParam.getUserName().equals(UserHeader.Admin)) {
            menus = menuDao.listMenuByType(MenuTypeEnum.接口.getCode());
        } else {
            menus = menuDao.listMenuByUserId(userEntity.getUniqueId());
        }
        String token = StrUtil.buildUuid();
        List<String> uriList = Lists.transform(menus, MenuEntity::getMenuUrl);
        UserBean userBean = new UserBean();
        userBean.build(UserHeader.AuthToken, token)
                .build(UserHeader.UniqueId, userEntity.getUniqueId())
                .build(UserHeader.NickName, userEntity.getNickName())
                .build(UserHeader.UserName, userEntity.getUserName())
                .build(UserHeader.AuthUriList, uriList);
        redisTemplate.opsForValue().set(token, JSONObject.toJSONString(userBean), loginExpireTime, TimeUnit.HOURS);
        return ResponseVO.SUCCESS(userBean);
    }

    @EventTrack(value = EventTrackEnum.客户端登出)
    @Override
    public ResponseVO loginOut(String token) {
        redisTemplate.delete(token);
        return ResponseVO.SUCCESS();
    }

    /**
     * 用户列表
     */
    @Override
    public ResponseVO list(Integer limit, Integer page, String userName) {
        Long count = userAdminDao.count(userName);
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        Integer offset = (page - 1) * limit;
        List<UserAdminEntity> list = userAdminDao.list(limit, offset, userName);
        return ResponseVO.SUCCESS(new PageDto<>(list, count, limit));
    }

    /**
     * 删除用户
     *
     * @param id 用户编号
     */
    @EventTrack(value = EventTrackEnum.删除用户)
    @Override
    public ResponseVO delete(List<Long> ids) {
        userAdminDao.deleteByIds(ids);
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO detail(Long id) {
        UserAdminEntity userAdminEntity = userAdminDao.getById(id);
        List<RoleUserEntity> roleUserList = roleUserDao.listByUserId(id);
        userAdminEntity.setRoleIdList(Lists.transform(roleUserList, RoleUserEntity::getRoleUniqueId));
        return ResponseVO.SUCCESS(userAdminEntity);
    }

    /**
     * 添加用户
     */
    @EventTrack(value = EventTrackEnum.新增用户)
    @Transactional
    @Override
    public ResponseVO save(UserParam userParam) {
        String salt = MD5Utils.getSalt();
        String md5SaltPwd = MD5Utils.getSaltMD5(defaultPassword, salt);
        UserAdminEntity user = new UserAdminEntity();
        user.setNickName(userParam.getNickName());
        user.setUserName(userParam.getUserName());
        user.setUserState(userParam.getUserState());
        user.setSalt(salt);
        user.setUserPassword(md5SaltPwd);
        userAdminDao.save(user);
        if (!CollectionUtils.isEmpty(userParam.getRoleIdList())) {
            saveBatchRoleUser(userParam.getRoleIdList(), user.getUniqueId());
        }
        return ResponseVO.SUCCESS();
    }

    private void saveBatchRoleUser(List<Long> roleIdList, Long userId) {
        List<RoleUserEntity> roleUserList = Lists.newArrayList();
        roleIdList.forEach(roleId -> {
            RoleUserEntity roleUser = new RoleUserEntity();
            roleUser.setRoleUniqueId(roleId);
            roleUser.setUserUniqueId(userId);
            roleUserList.add(roleUser);
        });
        roleUserDao.batchSave(roleUserList);
    }

    /**
     * 编辑用户
     */
    @EventTrack(value = EventTrackEnum.编辑用户)
    @Transactional
    @Override
    public ResponseVO update(UserParam userParam) {
        UserAdminEntity user = userAdminDao.getById(userParam.getUniqueId());
        if (user != null) {
            user.setUserState(userParam.getUserState());
            user.setNickName(userParam.getNickName());
            userAdminDao.update(user);
        }
        if (!CollectionUtils.isEmpty(userParam.getRoleIdList())) {
            roleUserDao.deleteByUserId(userParam.getUniqueId());
            saveBatchRoleUser(userParam.getRoleIdList(), userParam.getUniqueId());
        }
        return ResponseVO.SUCCESS();
    }

    @EventTrack(value = EventTrackEnum.更新密码)
    @Override
    public ResponseVO updatePassword(UserParam userParam) {
        String userName = CurrentAuthorization.getUserName();
        UserAdminEntity userEntity = userAdminDao.getByUserName(userName);
        if (userEntity == null) {
            return ResponseVO.FAIL("账号不存在");
        }
        String newSalt = MD5Utils.getSalt();
        String md5SaltOldPwd = MD5Utils.getSaltMD5(userParam.getPassword(), userEntity.getSalt());
        if (!md5SaltOldPwd.equals(userEntity.getUserPassword())) {
            return ResponseVO.FAIL(CodeMsgEnum.账号密码有误);
        }
        String md5SaltNewPwd = MD5Utils.getSaltMD5(userParam.getNewPassword(), newSalt);
        userEntity.setSalt(newSalt);
        userEntity.setUserPassword(md5SaltNewPwd);
        userAdminDao.update(userEntity);
        return ResponseVO.SUCCESS();
    }
}
