package cn.shop.mall.admin.controller;

import cn.shop.mall.admin.service.OrderService;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "订单相关")
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("订单列表")
    @GetMapping("/list")
    public ResponseVO list(@ApiParam(value = "起始条数", required = true) @RequestParam Integer limit,
                           @ApiParam(value = "每页条数", required = true) @RequestParam Integer page) {
        return orderService.list(limit, page);
    }

    @ApiOperation("订单详情")
    @GetMapping("/getById")
    public ResponseVO getById(@ApiParam(value = "订单编号", required = true) @RequestParam Long id) {
        return orderService.getById(id);
    }

}
