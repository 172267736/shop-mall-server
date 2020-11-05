package cn.shop.mall.biz.dao;

import cn.shop.mall.biz.entity.OrderAccountEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单清单表
 */
@Mapper
public interface OrderAccountDao {

    Integer save(OrderAccountEntity orderAccountEntity);

    Integer update(OrderAccountEntity orderAccountEntity);

    List<OrderAccountEntity> listByOrderId(Long orderId);

}
