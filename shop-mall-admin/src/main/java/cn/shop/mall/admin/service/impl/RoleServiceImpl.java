package cn.shop.mall.admin.service.impl;

import cn.shop.mall.admin.service.RoleService;
import cn.shop.mall.center.dao.MenuRoleDao;
import cn.shop.mall.center.dao.RoleDao;
import cn.shop.mall.center.entity.MenuRoleEntity;
import cn.shop.mall.center.entity.RoleEntity;
import cn.shop.mall.common.model.PageDto;
import cn.shop.mall.common.vo.ResponseVO;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseVO list() {
        Long count = roleDao.count();
        if (count == 0L) {
            return ResponseVO.SUCCESS(new PageDto<>());
        }
        List<RoleEntity> list = roleDao.list();
        return ResponseVO.SUCCESS(new PageDto<>(list, count));
    }

    /**
     * 添加角色
     */
    @Transactional
    @Override
    public ResponseVO save(String roleName, String menuIds) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(roleName);
        roleDao.save(roleEntity);
        if (!StringUtils.isEmpty(menuIds)) {
            List<Long> munuIdList = Arrays.stream(menuIds.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
            List<MenuRoleEntity> menuRoleList = Lists.newArrayList();
            for (Long menuId : munuIdList) {
                MenuRoleEntity menuRoleEntity = new MenuRoleEntity();
                menuRoleEntity.setRoleUniqueId(roleEntity.getUniqueId());
                menuRoleEntity.setMenuUniqueId(menuId);
                menuRoleList.add(menuRoleEntity);
            }
            menuRoleDao.batchSave(menuRoleList);
        }
        return ResponseVO.SUCCESS();
    }

    @Transactional
    @Override
    public ResponseVO update(Long roleId, String roleName, String menuIds) {
        if (!StringUtils.isEmpty(roleName)) {
            RoleEntity roleEntity = roleDao.getById(roleId);
            if (roleEntity != null) {
                roleEntity.setRoleName(roleName);
                roleDao.update(roleEntity);
            }
        }
        if (!StringUtils.isEmpty(menuIds)) {
            List<Long> munuIdList = Arrays.stream(menuIds.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
            List<MenuRoleEntity> menuRoleList = Lists.newArrayList();
            for (Long menuId : munuIdList) {
                MenuRoleEntity menuRoleEntity = new MenuRoleEntity();
                menuRoleEntity.setRoleUniqueId(roleId);
                menuRoleEntity.setMenuUniqueId(menuId);
                menuRoleList.add(menuRoleEntity);
            }
            menuRoleDao.deleteByRoleId(roleId);
            menuRoleDao.batchSave(menuRoleList);

        }
        return ResponseVO.SUCCESS();
    }

    /**
     * 删除角色
     */
    @Override
    public ResponseVO delete(Long id) {
        roleDao.deleteById(id);
        return ResponseVO.SUCCESS();
    }
}
