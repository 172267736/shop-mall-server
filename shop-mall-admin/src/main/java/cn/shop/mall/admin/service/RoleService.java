package cn.shop.mall.admin.service;

import cn.shop.mall.common.vo.ResponseVO;

import java.util.List;

public interface RoleService {

    ResponseVO list();

    ResponseVO save(String roleName, String menuId);

    ResponseVO update(Long roleId, String roleName, String menuIds);

    ResponseVO delete(Long id);

}
