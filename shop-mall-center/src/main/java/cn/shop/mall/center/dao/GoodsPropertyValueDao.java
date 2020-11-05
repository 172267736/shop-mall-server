package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.GoodsPropertyValueEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性值表
 */
@Mapper
public interface GoodsPropertyValueDao {

    Integer save(GoodsPropertyValueEntity goodsPropertyValueEntity);

    Integer update(GoodsPropertyValueEntity goodsPropertyValueEntity);

}
