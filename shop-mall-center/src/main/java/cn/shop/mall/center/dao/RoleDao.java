package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色表
 */
@Mapper
public interface RoleDao {

    Integer save(RoleEntity roleEntity);

    Integer update(RoleEntity roleEntity);

    List<RoleEntity> list();

    Long count();

    Integer deleteById(Long uniqueId);

    RoleEntity getById(Long uniqueId);

}
