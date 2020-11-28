package cn.shop.mall.app.service.impl;

import cn.shop.mall.app.service.AddressService;
import cn.shop.mall.center.dao.UserAllocationAddressDao;
import cn.shop.mall.center.entity.UserAllocationAddressEntity;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * Created by LSY on 2020/11/22.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserAllocationAddressDao userAllocationAddressDao;

    @Override
    public List<UserAllocationAddressEntity> list() {
        UserAllocationAddressEntity userAllocationAddressEntity = new UserAllocationAddressEntity();
        userAllocationAddressEntity.setUserUniqueId(CurrentAuthorization.getUserId());
        return userAllocationAddressDao.list(userAllocationAddressEntity);
    }

    @Transactional
    @Override
    public ResponseVO save(UserAllocationAddressEntity addressEntity) {
        addressEntity.setUserUniqueId(CurrentAuthorization.getUserId());
        updateAddressState(addressEntity);
        return ResponseVO.SUCCESS(userAllocationAddressDao.save(addressEntity));
    }

    @Override
    @Transactional
    public ResponseVO update(UserAllocationAddressEntity addressEntity) {
        addressEntity.setUserUniqueId(CurrentAuthorization.getUserId());
        updateAddressState(addressEntity);
        return ResponseVO.SUCCESS(userAllocationAddressDao.update(addressEntity));
    }

    @Override
    public UserAllocationAddressEntity queryById(Long addressId) {
        return userAllocationAddressDao.getById(addressId);
    }

    /**
     * 如果有默认地址，该用户的其它地址设置为false
     * @param addressEntity 地址实体
     */
    private void updateAddressState(UserAllocationAddressEntity addressEntity) {
        //如果有默认地址
        if (Objects.equals(1, addressEntity.getDefaultState())) {
            //修改其它地址非默认
            userAllocationAddressDao.updateStateByUserId(addressEntity.getUserUniqueId(), 0L);

        }
    }

}
