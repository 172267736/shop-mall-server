package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.model.GoodsClassifyParam;
import cn.shop.mall.admin.model.GoodsParam;
import cn.shop.mall.admin.model.GoodsSkuParam;
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

    @ApiOperation("添加分类")
    @PostMapping("/type/save")
    public ResponseVO saveType(@RequestBody GoodsClassifyParam goodsClassifyParam) {
        return goodsService.saveType(goodsClassifyParam);
    }

    @ApiOperation("编辑分类")
    @PostMapping("/type/update")
    public ResponseVO updateType(@RequestBody GoodsClassifyParam goodsClassifyParam) {
        return goodsService.updateType(goodsClassifyParam);
    }

    @ApiOperation("全部分类")
    @GetMapping("/type/listAll")
    public ResponseVO listAllType() {
        return goodsService.listAllType();
    }

    @ApiOperation("分类列表")
    @GetMapping("/type/list")
    public ResponseVO listType(@ApiParam(value = "起始条数", required = true) @RequestParam Integer limit,
                               @ApiParam(value = "每页条数", required = true) @RequestParam Integer page,
                               @ApiParam(value = "分类名称") @RequestParam(required = false) String classifyName) {
        return goodsService.listType(limit, page, classifyName);
    }

    @ApiOperation("分类详情")
    @GetMapping("/type/detail")
    public ResponseVO detailType(@ApiParam(value = "主键编号", required = true) @RequestParam Long id) {
        return goodsService.detailType(id);
    }

    @ApiOperation("商品列表")
    @GetMapping("/list")
    public ResponseVO list(@ApiParam(value = "起始条数", required = true) @RequestParam Integer limit,
                           @ApiParam(value = "每页条数", required = true) @RequestParam Integer page,
                           @ApiParam(value = "是否上架（0：否；1：是；）") @RequestParam(required = false) Integer status,
                           @ApiParam(value = "标签") @RequestParam(required = false) String goodsTag,
                           @ApiParam(value = "商品名称") @RequestParam(required = false) String goodsName,
                           @ApiParam(value = "所属分类") @RequestParam(required = false) Long belongClassifyId) {
        return goodsService.list(limit, page, status, goodsTag, goodsName, belongClassifyId);
    }

    @ApiOperation("商品详情")
    @GetMapping("/detail")
    public ResponseVO detail(@ApiParam(value = "商品编号", required = true) @RequestParam Long id) {
        return goodsService.detail(id);
    }

    @ApiOperation("属性详情")
    @GetMapping("/property/listByGoodsId")
    public Object listPropertyByGoodsId(@ApiParam(value = "商品编号", required = true) @RequestParam Long goodsId) {
        return goodsService.listPropertyByGoodsId(goodsId).getData();
    }

    @ApiOperation("库存详情")
    @GetMapping("/sku/listByGoodsId")
    public Object listSkuByGoodsId(@ApiParam(value = "商品编号", required = true) @RequestParam Long goodsId) {
        return goodsService.listSkuByGoodsId(goodsId).getData();
    }

    @ApiOperation("添加商品")
    @PostMapping("/save")
    public ResponseVO save(@RequestBody GoodsParam goodsParam) {
        return goodsService.save(goodsParam);
    }

    @ApiOperation("更新商品库存")
    @PostMapping("/updateSku")
    public ResponseVO updateSku(@RequestBody GoodsSkuParam goodsSkuParam) {
        return goodsService.updateSku(goodsSkuParam);
    }

    @ApiOperation("更新商品状态")
    @PostMapping("/updateStatus")
    public ResponseVO updateStatus(@RequestBody GoodsParam goodsParam) {
        return goodsService.updateStatus(goodsParam);
    }

    @ApiOperation("更新商品价格")
    @PostMapping("/updatePrice")
    public ResponseVO updateSku(@RequestBody GoodsParam goodsParam) {
        return goodsService.updatePrice(goodsParam);
    }

}
