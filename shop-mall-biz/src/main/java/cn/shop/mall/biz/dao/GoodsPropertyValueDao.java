package cn.shop.mall.biz.dao;

import cn.shop.mall.biz.entity.GoodsPropertyValueEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性值表
 */
@Mapper
public interface GoodsPropertyValueDao {

    Integer save(GoodsPropertyValueEntity goodsPropertyValueEntity);

    Integer update(GoodsPropertyValueEntity goodsPropertyValueEntity);

}
