package cn.shop.mall.biz.dao;

import cn.shop.mall.biz.entity.UserAllocationAddressEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 配送地址表
 */
@Mapper
public interface UserAllocationAddressDao {

    Integer save(UserAllocationAddressEntity userAllocationAddressEntity);

    Integer update(UserAllocationAddressEntity userAllocationAddressEntity);

}
