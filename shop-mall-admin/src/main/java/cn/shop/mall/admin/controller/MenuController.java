package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.service.MenuService;
import cn.shop.mall.biz.entity.MenuEntity;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.model.UserBean;
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
    public ResponseVO list() {
        return menuService.list();
    }

    @ApiOperation("新增菜单")
    @PostMapping("/save")
    public ResponseVO save(@ApiParam(value = "菜单名称", required = true) @RequestParam String menuName,
                           @ApiParam(value = "父编号", required = true) @RequestParam Long parentId,
                           @ApiParam(value = "菜单类型（1:根菜单;2:子菜单;3:权限接口;）", required = true) @RequestParam Integer menuType,
                           @ApiParam(value = "路径", required = true) @RequestParam String url,
                           @ApiParam(value = "排序号", required = true) @RequestParam Integer sortNumber,
                           @ApiParam(value = "图标") @RequestParam(required = false) String icon) {
        MenuEntity menuDto = new MenuEntity();
        menuDto.setIcon(icon);
        menuDto.setMenuName(menuName);
        menuDto.setSortNumber(sortNumber);
        menuDto.setMenuType(menuType);
        menuDto.setParentUniqueId(parentId);
        menuDto.setMenuUrl(url);
        return menuService.save(menuDto);
    }

    @ApiOperation("编辑菜单")
    @PostMapping("/update")
    public ResponseVO update(@ApiParam(value = "菜单编号", required = true) @RequestParam Long id,
                             @ApiParam(value = "菜单名称") @RequestParam(required = false) String menuName,
                             @ApiParam(value = "路径") @RequestParam(required = false) String url,
                             @ApiParam(value = "排序号") @RequestParam(required = false) Integer sortNumber,
                             @ApiParam(value = "图标") @RequestParam(required = false) String icon) {
        MenuEntity menuDto = new MenuEntity();
        menuDto.setUniqueId(id);
        menuDto.setMenuName(menuName);
        menuDto.setSortNumber(sortNumber);
        menuDto.setMenuUrl(url);
        menuDto.setIcon(icon);
        return menuService.save(menuDto);
    }

}
