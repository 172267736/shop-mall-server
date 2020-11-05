package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.service.RoleService;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "角色相关")
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("角色列表")
    @GetMapping("/list")
    public ResponseVO list() {
        return roleService.list();
    }

    @ApiOperation("删除角色")
    @PostMapping("/delete")
    public ResponseVO delete(@ApiParam(value = "角色编号", required = true) @RequestParam Long id) {
        return roleService.delete(id);
    }

    @ApiOperation("新增角色")
    @PostMapping("/save")
    public ResponseVO save(@ApiParam(value = "角色名称", required = true) @RequestParam String roleName,
                           @ApiParam(value = "菜单编号（多个用逗号隔开）", required = true) @RequestParam String menuIds) {
        return roleService.save(roleName, menuIds);
    }

    @ApiOperation("编辑角色")
    @PostMapping("/update")
    public ResponseVO update(@ApiParam(value = "角色编号", required = true) @RequestParam Long roleId,
                             @ApiParam(value = "角色名称") @RequestParam(required = false) String roleName,
                             @ApiParam(value = "菜单编号（多个用逗号隔开）") @RequestParam(required = false) String menuIds) {
        return roleService.update(roleId, roleName, menuIds);
    }
}