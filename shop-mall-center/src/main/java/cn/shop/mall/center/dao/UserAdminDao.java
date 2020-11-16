package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.UserAdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理用户表
 */
@Mapper
public interface UserAdminDao {

    Integer save(UserAdminEntity userAdminEntity);

    Integer update(UserAdminEntity userAdminEntity);

    UserAdminEntity getByUserName(String userName);

    List<UserAdminEntity> list(@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("userName") String userName);

    Integer deleteByIds(List<Long> ids);

    UserAdminEntity getById(Long id);

    Long count(@Param("userName") String userName);

}
