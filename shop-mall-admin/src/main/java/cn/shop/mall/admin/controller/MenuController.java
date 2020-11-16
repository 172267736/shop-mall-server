package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.model.MenuParam;
import cn.shop.mall.admin.service.MenuService;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.model.UserBean;
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

@Api(tags = "菜单相关")
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation("获取用户的菜单")
    @GetMapping("/listByUser")
    public ResponseVO listByUser() {
        UserBean userBean = CurrentAuthorization.getUserBean();
        return menuService.listByUser(userBean.getUserName(), userBean.getUniqueId());
    }

    @ApiOperation("菜单列表")
    @GetMapping("/list")
    public ResponseVO list(@ApiParam(value = "起始条数", required = true) @RequestParam Integer limit,
                           @ApiParam(value = "每页条数", required = true) @RequestParam Integer page,
                           @ApiParam(value = "菜单名称") @RequestParam(required = false) String menuName,
                           @ApiParam(value = "菜单类型（1：目录；2：菜单；3：按钮）") @RequestParam(required = false) Integer menuType) {
        return menuService.list(limit, page, menuName, menuType);
    }

    @ApiOperation("菜单列表")
    @GetMapping("/listAll")
    public ResponseVO listAll() {
        return menuService.listAll();
    }

    @ApiOperation("菜单详情")
    @GetMapping("/detail")
    public ResponseVO detail(@ApiParam(value = "菜单编号", required = true) @RequestParam Long id) {
        return menuService.detail(id);
    }

    @ApiOperation("新增菜单")
    @PostMapping("/save")
    public ResponseVO save(@RequestBody MenuParam menuParam) {
        return menuService.save(menuParam);
    }

    @ApiOperation("编辑菜单")
    @PostMapping("/update")
    public ResponseVO update(@RequestBody MenuParam menuParam) {
        return menuService.update(menuParam);
    }

    @ApiOperation("删除菜单")
    @PostMapping("/delete")
    public ResponseVO delete(@RequestBody MenuParam menuParam) {
        return menuService.delete(menuParam.getIds());
    }

}
