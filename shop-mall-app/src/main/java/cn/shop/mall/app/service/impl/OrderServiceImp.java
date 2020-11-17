package cn.shop.mall.app.service.impl;

import cn.shop.mall.app.service.OrderService;
import cn.shop.mall.center.dao.OrderAccountDao;
import cn.shop.mall.center.dao.OrderDao;
import cn.shop.mall.center.entity.OrderAccountEntity;
import cn.shop.mall.center.entity.OrderEntity;
import cn.shop.mall.common.exception.BizException;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.vo.ResponseVO;
import com.google.common.base.Strings;
import com.google.common.primitives.Longs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 订单业务类型
 * Created by LSY on 2020/11/15.
 */
@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderAccountDao orderAccountDao;

    /**
     * 我的订单
     * @param userId
     * @return
     */
    @Override
    public ResponseVO myOrder(Long userId) {




        return null;
    }

    /**
     * 创建订单
     * @param orderEntity
     * @return
     */
    @Override
    @Transactional
    public ResponseVO createOrder(OrderEntity orderEntity) {
        if(Objects.isNull(CurrentAuthorization.getUniqueId())){
            throw new BizException("用户ID为空");
        }
        orderEntity.setPayUserUniqueId(CurrentAuthorization.getUniqueId());
        //保存订单
        orderDao.save(orderEntity);

        List<OrderAccountEntity> orderDetailList = orderEntity.getAccountList();
        orderDetailList.forEach(orderDetail ->orderDetail.setOrderUniqueId(orderEntity.getUniqueId()));

        orderAccountDao.save()

        //保存订单详情

        return ResponseVO.SUCCESS();
    }
}
