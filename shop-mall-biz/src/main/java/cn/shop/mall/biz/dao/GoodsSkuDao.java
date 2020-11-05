package cn.shop.mall.biz.dao;

import cn.shop.mall.biz.entity.GoodsSkuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品库存表
 */
@Mapper
public interface GoodsSkuDao {

    Integer save(GoodsSkuEntity goodsSkuEntity);

    Integer update(GoodsSkuEntity goodsSkuEntity);

    Integer batchSave(List<GoodsSkuEntity> goodsSkuEntityList);

    Integer batchUpdate(List<GoodsSkuEntity> goodsSkuEntityList);

    List<GoodsSkuEntity> listByGoodsId(Long goodsId);

}
