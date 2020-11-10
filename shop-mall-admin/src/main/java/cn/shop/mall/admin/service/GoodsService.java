package cn.shop.mall.admin.service;

import cn.shop.mall.admin.model.GoodsClassifyParam;
import cn.shop.mall.admin.model.GoodsParam;
import cn.shop.mall.common.vo.ResponseVO;

public interface GoodsService {

    ResponseVO list(Integer limit, Integer page);

    ResponseVO listType(Integer limit, Integer page);

    ResponseVO saveType(GoodsClassifyParam goodsClassifyParam);

    ResponseVO save(GoodsParam goodsParam);

    ResponseVO update(GoodsParam goodsParam);

}
