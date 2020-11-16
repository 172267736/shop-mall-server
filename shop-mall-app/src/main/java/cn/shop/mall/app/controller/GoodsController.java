package cn.shop.mall.app.controller;

import cn.shop.mall.app.service.GoodsService;
import cn.shop.mall.center.entity.GoodsEntity;
import cn.shop.mall.common.vo.ResponseVO;
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
    @PostMapping("/queryGoods")
    public ResponseVO queryGoods(@RequestBody GoodsEntity goodsEntity) {
        return ResponseVO.SUCCESS(goodsService.queryGoods(goodsEntity));
    }

    /**
     * 商品详情
     * @param goodId 商品ID
     * @return 商品对象
     */
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
    @GetMapping("/category")
    public ResponseVO queryCategory(@RequestParam("parentId") Long parentId) {
        return ResponseVO.SUCCESS(goodsService.queryClassfiy(parentId));
    }
}
