package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.RoleUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色用户表
 */
@Mapper
public interface RoleUserDao {

    Integer save(RoleUserEntity roleUserEntity);

    Integer batchSave(List<RoleUserEntity> roleUserList);

    Integer update(RoleUserEntity roleUserEntity);

    List<RoleUserEntity> listByUserId(Long userId);

    Integer deleteByUserId(Long userId);

}
