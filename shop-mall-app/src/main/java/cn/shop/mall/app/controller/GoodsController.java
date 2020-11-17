package cn.shop.mall.app.controller;

import cn.shop.mall.app.service.GoodsService;
import cn.shop.mall.center.entity.GoodsEntity;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LSY on 2020/11/16.
 */
@RestController
@RequestMapping("/api/v1/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品列表
     *
     * @param goodsEntity 商品筛选条件
     * @return 商品列表
     */
    @ApiOperation("app-商品列表")
    @PostMapping("/queryGoods")
    public ResponseVO queryGoods(@RequestBody GoodsEntity goodsEntity,
                                 @ApiParam(value = "起始条数", required = true) @RequestParam Integer limit,
                                 @ApiParam(value = "每页条数", required = true) @RequestParam Integer page) {
        return ResponseVO.SUCCESS(goodsService.queryGoods(goodsEntity, limit, page));
    }

    /**
     * 商品详情
     * @param goodId 商品ID
     * @return 商品对象
     */
    @ApiOperation("app-商品详情")
    @GetMapping("queryGoodDetail/{goodId}")
    public ResponseVO queryGoodDetail(Long goodId) {
        return ResponseVO.SUCCESS(goodsService.queryGoodDetail(goodId));
    }

    /**
     * 商品分类
     *
     * @param parentId 父类ID
     * @return 商品分类列表
     */
    @ApiOperation("app-商品分类")
    @GetMapping("/category")
    public ResponseVO queryCategory(@RequestParam("parentId") Long parentId) {
        return ResponseVO.SUCCESS(goodsService.queryClassfiy(parentId));
    }
}
