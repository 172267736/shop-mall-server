package cn.shop.mall.admin.service;

import cn.shop.mall.common.vo.ResponseVO;

public interface OrderService {

    ResponseVO list();

    ResponseVO getById(Long id);

}
