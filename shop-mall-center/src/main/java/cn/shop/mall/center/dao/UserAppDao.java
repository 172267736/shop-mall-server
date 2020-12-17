package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.UserAppEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 应用用户表
 */
@Mapper
public interface UserAppDao {

    Integer save(UserAppEntity userAppEntity);

    Integer update(UserAppEntity userAppEntity);

    UserAppEntity get(@Param("weixinOpenid") String weixinOpenid);
}
