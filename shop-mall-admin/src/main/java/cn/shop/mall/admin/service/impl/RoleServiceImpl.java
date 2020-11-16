package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.event.EventTrack;
import cn.shop.mall.admin.model.RoleParam;
import cn.shop.mall.admin.service.RoleService;
import cn.shop.mall.center.dao.MenuRoleDao;
import cn.shop.mall.center.dao.RoleDao;
import cn.shop.mall.center.entity.MenuRoleEntity;
import cn.shop.mall.center.entity.RoleEntity;
import cn.shop.mall.common.enums.EventTrackEnum;
import cn.shop.mall.common.model.PageDto;
import cn.shop.mall.common.vo.ResponseVO;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private MenuRoleDao menuRoleDao;

    /**
     * 角色列表
     */
    @Override
    public ResponseVO list(Integer limit, Integer page, String roleName) {
        Long count = roleDao.count(roleName);
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        Integer offset = (page - 1) * limit;
        List<RoleEntity> list = roleDao.list(limit, offset, roleName);
        return ResponseVO.SUCCESS(new PageDto<>(list, count, limit));
    }

    /**
     * 角色列表
     */
    @Override
    public ResponseVO listAll() {
        return ResponseVO.SUCCESS(roleDao.listAll());
    }

    /**
     * 添加角色
     */
    @EventTrack(value = EventTrackEnum.新增角色)
    @Transactional
    @Override
    public ResponseVO save(RoleParam roleParam) {
        RoleEntity roleEntity = new RoleEntity();
        if (StringUtils.isEmpty(roleParam.getRoleName())) {
            return ResponseVO.FAIL("角色名称不能为空");
        }
        roleEntity.setRoleName(roleParam.getRoleName());
        roleEntity.setRoleRemark(roleParam.getRoleRemark());
        roleDao.save(roleEntity);
        if (!CollectionUtils.isEmpty(roleParam.getMenuIdList())) {
            List<MenuRoleEntity> menuRoleList = buildMenuRoleList(roleEntity.getUniqueId(), roleParam.getMenuIdList());
            menuRoleDao.batchSave(menuRoleList);
        }
        return ResponseVO.SUCCESS();
    }

    @EventTrack(value = EventTrackEnum.编辑角色)
    @Transactional
    @Override
    public ResponseVO update(RoleParam roleParam) {
        if (!StringUtils.isEmpty(roleParam.getRoleName())) {
            RoleEntity roleEntity = roleDao.getById(roleParam.getUniqueId());
            if (roleEntity != null) {
                roleEntity.setRoleName(roleParam.getRoleName());
                roleDao.update(roleEntity);
            }
        }
        if (!StringUtils.isEmpty(roleParam.getMenuIdList())) {
            menuRoleDao.deleteByRoleIds(Lists.newArrayList(roleParam.getUniqueId()));
            List<MenuRoleEntity> menuRoleList = buildMenuRoleList(roleParam.getUniqueId(), roleParam.getMenuIdList());
            menuRoleDao.batchSave(menuRoleList);
        }
        return ResponseVO.SUCCESS();
    }

    private List<MenuRoleEntity> buildMenuRoleList(Long roleId, List<Long> menuIdList) {
        List<MenuRoleEntity> menuRoleList = Lists.newArrayList();
        for (Long menuId : menuIdList) {
            MenuRoleEntity menuRoleEntity = new MenuRoleEntity();
            menuRoleEntity.setRoleUniqueId(roleId);
            menuRoleEntity.setMenuUniqueId(menuId);
            menuRoleList.add(menuRoleEntity);
        }
        return menuRoleList;
    }

    /**
     * 删除角色
     */
    @EventTrack(value = EventTrackEnum.删除角色)
    @Transactional
    @Override
    public ResponseVO delete(List<Long> ids) {
        roleDao.deleteByIds(ids);
        menuRoleDao.deleteByRoleIds(ids);
        return ResponseVO.SUCCESS();
    }

    @Override
    public ResponseVO detail(Long id) {
        RoleEntity roleEntity = roleDao.getById(id);
        List<MenuRoleEntity> menuRoleList = menuRoleDao.listByRoleId(id);
        List<Long> menuIdList = Lists.transform(menuRoleList, MenuRoleEntity::getMenuUniqueId);
        roleEntity.setMenuIdList(menuIdList);
        return ResponseVO.SUCCESS(roleEntity);
    }
}
