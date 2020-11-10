package cn.shop.mall.admin.service;

import cn.shop.mall.admin.model.RoleParam;
import cn.shop.mall.common.vo.ResponseVO;

public interface RoleService {

    ResponseVO list(Integer limit, Integer page, String roleName);

    ResponseVO save(RoleParam roleParam);

    ResponseVO update(RoleParam roleParam);

    ResponseVO delete(Long id);

    ResponseVO detail(Long id);

}
