package cn.shop.mall.biz.dao;

import cn.shop.mall.biz.entity.MenuRoleEntity;
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

}
