package cn.shop.mall.admin.service;

import cn.shop.mall.admin.model.GoodsClassifyParam;
import cn.shop.mall.admin.model.GoodsParam;
import cn.shop.mall.admin.model.GoodsSkuParam;
import cn.shop.mall.common.vo.ResponseVO;

public interface GoodsService {

    ResponseVO listType(Integer limit, Integer page, String classifyName);

    ResponseVO detailType(Long id);

    ResponseVO listAllType();

    ResponseVO saveType(GoodsClassifyParam goodsClassifyParam);

    ResponseVO updateType(GoodsClassifyParam goodsClassifyParam);

    ResponseVO list(Integer limit, Integer page, Integer status, String goodsTag, String goodsName, Long belongClassifyId);

    ResponseVO detail(Long id);

    ResponseVO listPropertyByGoodsId(Long goodsId);

    ResponseVO listSkuByGoodsId(Long goodsId);

    ResponseVO save(GoodsParam goodsParam);

    ResponseVO updatePrice(GoodsParam goodsParam);

    ResponseVO updateSku(GoodsSkuParam goodsSkuParam);

    ResponseVO updateStatus(GoodsParam goodsParam);

}
