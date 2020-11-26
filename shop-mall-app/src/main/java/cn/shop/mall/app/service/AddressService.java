package cn.shop.mall.app.service;

import cn.shop.mall.center.entity.UserAllocationAddressEntity;
import cn.shop.mall.common.vo.ResponseVO;

import java.util.List;

/**
 * Created by LSY on 2020/11/22.
 */
public interface AddressService {

    List<UserAllocationAddressEntity> list();

    ResponseVO save(UserAllocationAddressEntity addressEntity);

    ResponseVO update(UserAllocationAddressEntity addressEntity);

    UserAllocationAddressEntity queryById(Long addressId);
}
