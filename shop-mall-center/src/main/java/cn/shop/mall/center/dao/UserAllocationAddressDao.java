package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.UserAllocationAddressEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 配送地址表
 */
@Mapper
public interface UserAllocationAddressDao {

    Integer save(UserAllocationAddressEntity userAllocationAddressEntity);

    Integer update(UserAllocationAddressEntity userAllocationAddressEntity);

    Integer updateStateByUserId(@Param("userUniqueId") Long userUniqueId, @Param("defaultState") Long defaultState);

    UserAllocationAddressEntity getById(@Param("uniqueId") Long uniqueId);

    List<UserAllocationAddressEntity> list(UserAllocationAddressEntity userAllocationAddressEntity);

}
