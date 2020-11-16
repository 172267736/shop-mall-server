package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.GoodsPropertyValueEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品属性值表
 */
@Mapper
public interface GoodsPropertyValueDao {

    Integer save(GoodsPropertyValueEntity goodsPropertyValueEntity);

    Integer update(GoodsPropertyValueEntity goodsPropertyValueEntity);

    List<GoodsPropertyValueEntity> listByKeyIds(List<Long> keyIds);

}
