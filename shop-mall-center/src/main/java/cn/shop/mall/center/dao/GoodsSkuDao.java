package cn.shop.mall.center.dao;

import cn.shop.mall.center.entity.GoodsSkuEntity;
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

    Integer updateStock(GoodsSkuEntity goodsSkuEntity);
}
