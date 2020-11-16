package cn.shop.mall.app.service;

import cn.shop.mall.center.entity.GoodsClassifyEntity;
import cn.shop.mall.center.entity.GoodsEntity;

import java.util.List;

/**
 * Created by LSY on 2020/11/16.
 */
public interface GoodsService {

    List<GoodsEntity> queryGoods(GoodsEntity goodsEntity);

    GoodsEntity queryGoodDetail(Long goodId);

    GoodsClassifyEntity queryClassfiy(Long parentId);

}
