package cn.shop.mall.admin.service;

import cn.shop.mall.admin.model.MenuParam;
import cn.shop.mall.common.vo.ResponseVO;

public interface MenuService {

    ResponseVO listByUser(String userName, Long userId);

    ResponseVO list(Integer limit, Integer page, String menuName, Integer menuType);

    ResponseVO listAll();

    ResponseVO detail(Long id);

    ResponseVO save(MenuParam menuParam);

    ResponseVO update(MenuParam menuParam);

    ResponseVO delete(Long id);

}
