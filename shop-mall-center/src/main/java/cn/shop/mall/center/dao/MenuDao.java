package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单表
 */
@Mapper
public interface MenuDao {

    Integer save(MenuEntity menuEntity);

    Integer update(MenuEntity menuEntity);

    List<MenuEntity> list(@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("menuName") String menuName, @Param("menuType") Integer menuType);

    List<MenuEntity> listAllMenu();

    List<MenuEntity> listAll();

    List<MenuEntity> listMenuByUserId(Long userId);

    List<MenuEntity> listMenuByType(Integer type);

    Long count(@Param("menuName") String menuName, @Param("menuType") Integer menuType);

    MenuEntity getById(Long id);

    Integer deleteByIds(List<Long> ids);

}
