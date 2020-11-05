package cn.shop.mall.admin.service;

import cn.shop.mall.biz.entity.MenuEntity;
import cn.shop.mall.common.vo.ResponseVO;

public interface MenuService {

    ResponseVO listByUser(String userName, Long userId);

    ResponseVO list();

    ResponseVO save(MenuEntity menuEntity);

    ResponseVO update(MenuEntity menuEntity);

}
