package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.UserAdminEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 管理用户表
 */
@Mapper
public interface UserAdminDao {

    Integer save(UserAdminEntity userAdminEntity);

    Integer update(UserAdminEntity userAdminEntity);

    UserAdminEntity getByUserName(String userName);

    List<UserAdminEntity> list();

    Integer deleteById(Long id);

    UserAdminEntity getById(Long id);

    Long count();

}
