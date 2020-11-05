package cn.shop.mall.admin.service;

import cn.shop.mall.admin.model.GoodsParam;
import cn.shop.mall.common.vo.ResponseVO;

public interface GoodsService {

    ResponseVO list();

    ResponseVO listType();

    ResponseVO saveType(String classifyName, Long classifyParentId, String classifyIcon, String classifyDescription);

    ResponseVO save(GoodsParam goodsParam);

    ResponseVO update(GoodsParam goodsParam);

}
