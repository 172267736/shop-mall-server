package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.MenuRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单角色表
 */
@Mapper
public interface MenuRoleDao {

    Integer save(MenuRoleEntity menuRoleEntity);

    Integer update(MenuRoleEntity menuRoleEntity);

    Integer batchSave(List<MenuRoleEntity> menuRoleList);

    Integer deleteByRoleId(Long roleId);

    List<MenuRoleEntity> listByRoleId(Long roleId);

}
