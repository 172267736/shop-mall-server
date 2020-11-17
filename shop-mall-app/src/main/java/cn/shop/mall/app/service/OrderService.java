package cn.shop.mall.app.service;

import cn.shop.mall.center.entity.OrderEntity;
import cn.shop.mall.common.vo.ResponseVO;

public interface OrderService {

    ResponseVO myOrder(Long userId);

    ResponseVO createOrder(OrderEntity orderEntity);

}
