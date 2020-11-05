package cn.shop.mall.biz.dao;

import cn.shop.mall.biz.entity.RoleUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色用户表
 */
@Mapper
public interface RoleUserDao {

    Integer save(RoleUserEntity roleUserEntity);

    Integer update(RoleUserEntity roleUserEntity);

    RoleUserEntity getByUserId(Long userId);

}
