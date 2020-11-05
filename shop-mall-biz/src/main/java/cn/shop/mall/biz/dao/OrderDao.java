package cn.shop.mall.biz.dao;

import cn.shop.mall.biz.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单表
 */
@Mapper
public interface OrderDao {

    Integer save(OrderEntity orderEntity);

    Integer update(OrderEntity orderEntity);

    List<OrderEntity> list();

    OrderEntity getById(Long id);

    Long count();

}
