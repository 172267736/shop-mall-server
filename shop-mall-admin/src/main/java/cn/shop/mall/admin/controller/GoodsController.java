package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.model.GoodsClassifyParam;
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
    public ResponseVO listType(@ApiParam(value = "起始条数", required = true) @RequestParam Integer limit,
                               @ApiParam(value = "每页条数", required = true) @RequestParam Integer page) {
        return goodsService.listType(limit, page);
    }

    @ApiOperation("添加分类")
    @PostMapping("/type/save")
    public ResponseVO saveType(@RequestBody GoodsClassifyParam goodsClassifyParam) {
        return goodsService.saveType(goodsClassifyParam);
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
