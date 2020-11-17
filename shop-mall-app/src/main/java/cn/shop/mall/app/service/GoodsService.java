package cn.shop.mall.app.service;

import cn.shop.mall.center.entity.GoodsClassifyEntity;
import cn.shop.mall.center.entity.GoodsEntity;
import cn.shop.mall.common.model.PageDto;

import java.util.List;

/**
 * Created by LSY on 2020/11/16.
 */
public interface GoodsService {

    PageDto<List<GoodsEntity>> queryGoods(GoodsEntity goodsEntity, Integer limit, Integer page);

    GoodsEntity queryGoodDetail(Long goodId);

    GoodsClassifyEntity queryClassfiy(Long parentId);

}
