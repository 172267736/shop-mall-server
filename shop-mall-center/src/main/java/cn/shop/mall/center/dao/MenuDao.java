package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单表
 */
@Mapper
public interface MenuDao {

    Integer save(MenuEntity menuEntity);

    Integer update(MenuEntity menuEntity);

    List<MenuEntity> list();

    List<MenuEntity> listAllMenu();

    List<MenuEntity> listMenuByUserId(Long userId);

    List<MenuEntity> listMenuByType(Integer type);

    Long count();

}