package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.model.GoodsParam;
import cn.shop.mall.admin.service.GoodsService;
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

@Api(tags = "商品相关")
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("分类列表")
    @GetMapping("/type/list")
    public ResponseVO listType() {
        return goodsService.listType();
    }

    @ApiOperation("添加分类")
    @PostMapping("/type/save")
    public ResponseVO saveType(@ApiParam(value = "分类名称", required = true) @RequestParam String classifyName,
                               @ApiParam(value = "父编号") @RequestParam(required = false) Long classifyParentId,
                               @ApiParam(value = "分类图标") @RequestParam(required = false) String classifyIcon,
                               @ApiParam(value = "分类说明") @RequestParam(required = false) String classifyDescription) {
        return goodsService.saveType(classifyName, classifyParentId, classifyIcon, classifyDescription);
    }

    @ApiOperation("添加商品")
    @PostMapping("/save")
    public ResponseVO save(@RequestBody GoodsParam goodsParam) {
        return goodsService.save(goodsParam);
    }

    @ApiOperation("更新商品")
    @PostMapping("/update")
    public ResponseVO update(@RequestBody GoodsParam goodsParam) {
        return goodsService.update(goodsParam);
    }


}
