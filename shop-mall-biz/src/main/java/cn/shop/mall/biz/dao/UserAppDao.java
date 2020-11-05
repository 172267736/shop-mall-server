package cn.shop.mall.biz.dao;

import cn.shop.mall.biz.entity.UserAppEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 应用用户表
 */
@Mapper
public interface UserAppDao {

    Integer save(UserAppEntity userAppEntity);

    Integer update(UserAppEntity userAppEntity);

}
