package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.OrderAccountEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单清单表
 */
@Mapper
public interface OrderAccountDao {

    Integer save(OrderAccountEntity orderAccountEntity);

    Integer saveBatch(List<OrderAccountEntity> orderAccountEntityList);

    Integer update(OrderAccountEntity orderAccountEntity);

    List<OrderAccountEntity> listByOrderId(@Param("orderUniqueId") Long orderUniqueId);

}
