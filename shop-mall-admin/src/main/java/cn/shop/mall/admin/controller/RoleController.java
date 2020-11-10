package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.model.RoleParam;
import cn.shop.mall.admin.service.RoleService;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseVO list(@ApiParam(value = "起始条数", required = true) @RequestParam Integer limit,
                           @ApiParam(value = "每页条数", required = true) @RequestParam Integer page,
                           @ApiParam(value = "角色名") @RequestParam(required = false) String roleName) {
        return roleService.list(limit, page, roleName);
    }

    @ApiOperation("角色详情")
    @GetMapping("/detail")
    public ResponseVO detail(@ApiParam(value = "角色编号", required = true) @RequestParam Long id) {
        return roleService.detail(id);
    }

    @ApiOperation("删除角色")
    @PostMapping("/delete")
    public ResponseVO delete(@ApiParam(value = "角色编号", required = true) @RequestParam Long id) {
        return roleService.delete(id);
    }

    @ApiOperation("新增角色")
    @PostMapping("/save")
    public ResponseVO save(@RequestBody RoleParam roleParam) {
        return roleService.save(roleParam);
    }

    @ApiOperation("编辑角色")
    @PostMapping("/update")
    public ResponseVO update(@RequestBody RoleParam roleParam) {
        return roleService.update(roleParam);
    }
}