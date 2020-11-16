package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色表
 */
@Mapper
public interface RoleDao {

    Integer save(RoleEntity roleEntity);

    Integer update(RoleEntity roleEntity);

    List<RoleEntity> list(@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("roleName") String roleName);

    List<RoleEntity> listAll();

    Long count(@Param("roleName") String roleName);

    Integer deleteByIds(List<Long> ids);

    RoleEntity getById(Long uniqueId);

}
