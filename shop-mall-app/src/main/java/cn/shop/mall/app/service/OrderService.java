package cn.shop.mall.app.service;

import cn.shop.mall.center.entity.OrderEntity;
import cn.shop.mall.common.vo.ResponseVO;

public interface OrderService {

    ResponseVO myOrder(OrderEntity orderEntity, Integer limit, Integer page);

    ResponseVO myOrderDetail(Long orderId);

    ResponseVO createOrder(OrderEntity orderEntity);

}
