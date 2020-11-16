package cn.shop.mall.admin.service;

import cn.shop.mall.admin.model.RoleParam;
import cn.shop.mall.common.vo.ResponseVO;

import java.util.List;

public interface RoleService {

    ResponseVO list(Integer limit, Integer page, String roleName);

    ResponseVO listAll();

    ResponseVO save(RoleParam roleParam);

    ResponseVO update(RoleParam roleParam);

    ResponseVO delete(List<Long> ids);

    ResponseVO detail(Long id);

}
