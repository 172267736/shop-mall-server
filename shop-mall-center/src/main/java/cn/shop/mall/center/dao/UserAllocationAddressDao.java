package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.UserAllocationAddressEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 配送地址表
 */
@Mapper
public interface UserAllocationAddressDao {

    Integer save(UserAllocationAddressEntity userAllocationAddressEntity);

    Integer update(UserAllocationAddressEntity userAllocationAddressEntity);

}
