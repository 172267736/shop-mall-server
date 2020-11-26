package cn.shop.mall.app.service;

import cn.shop.mall.center.entity.OrderEntity;
import cn.shop.mall.common.vo.ResponseVO;

public interface OrderService {

    ResponseVO myOrder(Integer status, Integer page, Integer limit);

    ResponseVO myOrderDetail(Long orderId);

    ResponseVO createOrder(OrderEntity orderEntity);

}
