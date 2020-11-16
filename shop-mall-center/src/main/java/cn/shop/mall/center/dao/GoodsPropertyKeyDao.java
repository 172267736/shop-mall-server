package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.GoodsPropertyKeyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品属性键表
 */
@Mapper
public interface GoodsPropertyKeyDao {

    Integer save(GoodsPropertyKeyEntity goodsPropertyKeyEntity);

    Integer update(GoodsPropertyKeyEntity goodsPropertyKeyEntity);

    List<GoodsPropertyKeyEntity> listByGoodsId(Long goodsId);

}
