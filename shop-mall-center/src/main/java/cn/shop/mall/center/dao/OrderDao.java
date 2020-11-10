package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单表
 */
@Mapper
public interface OrderDao {

    Integer save(OrderEntity orderEntity);

    Integer update(OrderEntity orderEntity);

    List<OrderEntity> list(@Param("limit") Integer limit, @Param("offset") Integer offset);

    OrderEntity getById(Long id);

    Long count();

}
