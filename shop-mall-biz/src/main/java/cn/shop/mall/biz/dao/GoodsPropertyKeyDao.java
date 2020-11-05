package cn.shop.mall.biz.dao;

import cn.shop.mall.biz.entity.GoodsPropertyKeyEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性键表
 */
@Mapper
public interface GoodsPropertyKeyDao {

    Integer save(GoodsPropertyKeyEntity goodsPropertyKeyEntity);

    Integer update(GoodsPropertyKeyEntity goodsPropertyKeyEntity);

}
