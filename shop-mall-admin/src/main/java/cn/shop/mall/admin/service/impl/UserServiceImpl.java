package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.event.EventTrack;
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
import org.springframework.util.StringUtils;

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
    public ResponseVO login(String userName, String passWord) {
        UserAdminEntity userEntity = userAdminDao.getByUserName(userName);
        if (userEntity == null) {
            return ResponseVO.FAIL("账号不存在");
        }
        String md5SaltPwd = MD5Utils.getSaltMD5(passWord, userEntity.getSalt());
        if (!md5SaltPwd.equals(userEntity.getUserPassword())) {
            return ResponseVO.FAIL(CodeMsgEnum.账号密码有误);
        }
        List<MenuEntity> menus;
        if (userName.equals(UserHeader.Admin)) {
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
        return ResponseVO.SUCCESS(new PageDto<>(list, count));
    }

    /**
     * 删除用户
     *
     * @param id 用户编号
     */
    @Override
    public ResponseVO delete(Long id) {
        userAdminDao.deleteById(id);
        return ResponseVO.SUCCESS();
    }

    /**
     * 添加用户
     */
    @Transactional
    @Override
    public ResponseVO save(String userName, String nickName, Long roleId) {
        String salt = MD5Utils.getSalt();
        String md5SaltPwd = MD5Utils.getSaltMD5(defaultPassword, salt);
        UserAdminEntity user = new UserAdminEntity();
        user.setNickName(nickName);
        user.setUserName(userName);
        user.setSalt(salt);
        user.setUserPassword(md5SaltPwd);
        userAdminDao.save(user);
        RoleUserEntity roleUser = new RoleUserEntity();
        roleUser.setRoleUniqueId(roleId);
        roleUser.setUserUniqueId(user.getUniqueId());
        roleUserDao.save(roleUser);
        return ResponseVO.SUCCESS();
    }

    /**
     * 编辑用户
     */
    @Transactional
    @Override
    public ResponseVO update(Long userId, String nickName, Long roleId) {
        if (!StringUtils.isEmpty(nickName)) {
            UserAdminEntity user = userAdminDao.getById(userId);
            if (user != null) {
                user.setNickName(nickName);
                userAdminDao.update(user);
            }
        }
        if (StringUtils.isEmpty(roleId)) {
            RoleUserEntity roleUser = roleUserDao.getByUserId(userId);
            if (roleUser != null) {
                roleUser.setRoleUniqueId(roleId);
                roleUserDao.update(roleUser);
            }
        }
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO updatePassword(String userName, String oldPassword, String newPassword) {
        if (!CurrentAuthorization.getUserName().equals(userName)) {
            return ResponseVO.FAIL("非本人操作");
        }
        UserAdminEntity userEntity = userAdminDao.getByUserName(userName);
        if (userEntity == null) {
            return ResponseVO.FAIL("账号不存在");
        }

        String newSalt = MD5Utils.getSalt();
        String md5SaltOldPwd = MD5Utils.getSaltMD5(oldPassword, userEntity.getSalt());
        if (!md5SaltOldPwd.equals(userEntity.getUserPassword())) {
            return ResponseVO.FAIL(CodeMsgEnum.账号密码有误);
        }
        String md5SaltNewPwd = MD5Utils.getSaltMD5(newPassword, newSalt);
        userEntity.setSalt(newSalt);
        userEntity.setUserPassword(md5SaltNewPwd);
        userAdminDao.update(userEntity);
        return ResponseVO.SUCCESS();
    }
}
