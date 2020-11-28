package cn.shop.mall.app.controller;

import cn.shop.mall.app.wechat.OrderPay;
import cn.shop.mall.app.wechat.WechatUtil;
import cn.shop.mall.common.model.CurrentAuthorization;
import cn.shop.mall.common.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by LSY on 2020/11/17.
 */
@Api("支付")
@RestController
@RequestMapping("/api/pay/")
public class PayController {

    @ApiOperation("去支付")
    @PostMapping("/toPay")
    public ResponseVO toPay(@ApiParam(value = "订单编号", required = true) @RequestParam Long id) {
        //获取客户端的ip地址
        String spbill_create_ip = CurrentAuthorization.getRequestIp();
        //生成六位数随机字符串
        String nonce_str = WechatUtil.createCode(6);
        //调用微信支付接口 生成订单
        //这是生成了一个订单类进行参数封装
        OrderPay orderPay = new OrderPay();
        //商品详情用于描述商品
        orderPay.setBody("商品描述");
        //随机生成的字符串不能超过32位
        orderPay.setNonce_str(nonce_str);
        //商户订单号 自己订单表的id或者商户系统id 是自己系统的  不能超过32位
        orderPay.setOut_trade_no("随机给一个不超过32位字符串");
        //ip地址 谁调用就是谁的地址 上面有用api获取
        orderPay.setSpbill_create_ip(spbill_create_ip);
        //金额 这里的金额实际业务需要乘 100 微信是按照分来算的 要转换位字符串 微信识别
        orderPay.setTotal_fee("1");
        //用户的openId 这个需要调用微信获取openId 一般都是存储到用户表
        orderPay.setOpenid("");
        //下单接口
        Map<String, Object> objectMap = WechatUtil.wxPay(orderPay);
        return ResponseVO.SUCCESS();
    }

    @ApiOperation("支付回调")
    @PostMapping("/pay/callback")
    public void payCallback(HttpServletRequest request) {
        BufferedReader br = null;
        try {
            //微信通过流传输
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            //sb为微信返回的xml
            String notityXml = sb.toString();
        } catch (Exception e) {

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {

                }
            }
        }
    }

}
