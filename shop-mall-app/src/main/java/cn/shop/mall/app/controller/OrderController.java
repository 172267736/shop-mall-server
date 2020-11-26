package cn.shop.mall.app.controller;

import cn.shop.mall.app.service.OrderService;
import cn.shop.mall.app.service.UserAppService;
import cn.shop.mall.app.wechat.OrderPay;
import cn.shop.mall.app.wechat.WechatUtil;
import cn.shop.mall.center.entity.OrderAccountEntity;
import cn.shop.mall.center.entity.OrderEntity;
import cn.shop.mall.common.enums.CodeMsgEnum;
import cn.shop.mall.common.exception.BizException;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

@Api(tags = "订单相关")
@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("我的订单")
    @GetMapping("/myOrder")
    public ResponseVO myOrder(@ApiParam(value = "status") @RequestParam(value = "status", required = false) Integer status,
                              @ApiParam(value = "page") @RequestParam("page") Integer page,
                              @ApiParam(value = "limit") @RequestParam("limit") Integer limit) {
        return orderService.myOrder(status, page, limit);
    }

    @ApiOperation("订单详情")
    @GetMapping("/myOrderDetail/{orderId}")
    public ResponseVO myOrder(@ApiParam(value = "订单ID") @PathVariable Long orderId) {
        return orderService.myOrderDetail(orderId);
    }

    @ApiOperation("创建订单")
    @PostMapping("/createOrder")
    public ResponseVO createOrder(@ApiParam(value = "orderEntity") @RequestBody OrderEntity orderEntity) {
        try{
            return orderService.createOrder(orderEntity);
        }catch (BizException e){
            return ResponseVO.FAIL(CodeMsgEnum.STOCK_MESSAGE.getCode(), CodeMsgEnum.STOCK_MESSAGE.getMsg());
        }
    }
}
