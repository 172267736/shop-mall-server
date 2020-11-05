package cn.shop.mall.app.wechat;

import cn.shop.mall.common.util.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WechatUtil {

    //小程序appid
    private static final String appid = "";

    //小程序密钥
    private static final String mch_id = "";

    //商家key
    private static final String key = "";

    //微信调用地址
    private static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    //交易类型  不同业务需求选择不同  详见微信开发文档
    private static final String trade_type = "JSAPI";

    //支付成功通知回调地址 需要外网能访问你的项目  可以使用花生壳进行内网穿透
    private static final String notify_url = "";

    //调用支付 统一下单 接口，返回Map数据
    public static Map<String, Object> wxPay(OrderPay orderPay) {
        //controller层封装的对象传递过来
        orderPay.setAppid(appid);
        orderPay.setMch_id(mch_id);
        orderPay.setTrade_type(trade_type);
        orderPay.setKey(key);
        orderPay.setPay_url(pay_url);
        orderPay.setNotify_url(notify_url);
        try {
            //参数封装成一个map
            Map<String, String> packageParams = new HashMap<>();
            packageParams.put("appid", orderPay.getAppid());
            packageParams.put("mch_id", orderPay.getMch_id());
            packageParams.put("nonce_str", orderPay.getNonce_str());
            packageParams.put("body", orderPay.getBody());
            packageParams.put("out_trade_no", orderPay.getOut_trade_no());
            packageParams.put("total_fee", orderPay.getTotal_fee());
            packageParams.put("spbill_create_ip", orderPay.getSpbill_create_ip());
            packageParams.put("notify_url", orderPay.getNotify_url());
            packageParams.put("trade_type", orderPay.getTrade_type());
            packageParams.put("openid", orderPay.getOpenid());
            //除去数组中的空值和签名参数
            packageParams = WechatUtil.paraFilter(packageParams);
            String prestr = WechatUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            String mysign = WechatUtil.sign(prestr, orderPay.getKey(), "utf-8").toUpperCase();
            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = "<xml version='1.0' encoding='utf-8'>" + "<appid>" + orderPay.getAppid() + "</appid>"
                    + "<body><![CDATA[" + orderPay.getBody() + "]]></body>"
                    + "<mch_id>" + orderPay.getMch_id() + "</mch_id>"
                    + "<nonce_str>" + orderPay.getNonce_str() + "</nonce_str>"
                    + "<notify_url>" + orderPay.getNotify_url() + "</notify_url>"
                    + "<openid>" + orderPay.getOpenid() + "</openid>"
                    + "<out_trade_no>" + orderPay.getOut_trade_no() + "</out_trade_no>"
                    + "<spbill_create_ip>" + orderPay.getSpbill_create_ip() + "</spbill_create_ip>"
                    + "<total_fee>" + orderPay.getTotal_fee() + "</total_fee>"
                    + "<trade_type>" + orderPay.getTrade_type() + "</trade_type>"
                    + "<sign>" + mysign + "</sign>"
                    + "</xml>";
            //调用统一下单接口，并接受返回的结果
            String result = HttpUtil.sendHttpPostJson(orderPay.getPay_url(), xml);

            // 将解析结果存储在HashMap中
            JSONObject objResult = JSONObject.parseObject(result);
            //返回状态码
            String return_code = objResult.getString("return_code");

            //返回给移动端需要的参数
            Map<String, Object> response = new HashMap<>();
            if (return_code.equals("SUCCESS")) {
                // 业务结果
                String prepay_id = objResult.getString("prepay_id");//返回的预付单信息
                response.put("nonceStr", orderPay.getNonce_str());
                response.put("package", "prepay_id=" + prepay_id);
                long timeStamp = System.currentTimeMillis() / 1000;
                response.put("timeStamp", timeStamp + "");
                //这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                String stringSignTemp = "appId=" + orderPay.getAppid() + "&nonceStr=" + orderPay.getNonce_str() + "&package=prepay_id=" + prepay_id + "&signType=" + "MD5" + "&timeStamp=" + timeStamp;
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                String paySign = WechatUtil.sign(stringSignTemp, orderPay.getKey(), "utf-8").toUpperCase();
                System.out.println("再次签名paySign=" + paySign);
                response.put("paySign", paySign);
            }
            //返回处理结果 下单到此就处理完成了
            response.put("appid", orderPay.getOpenid());
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//生成md5格式签名

    public static String sign(String text, String key, String input_charset) {
        text = text + "&key=" + key;
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }

    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

    /**
     * 生成6位或10位随机数 param codeLength(多少位)
     */
    public static String createCode(int codeLength) {
        String code = "";
        for (int i = 0; i < codeLength; i++) {
            code += (int) (Math.random() * 9);
        }
        return code;
    }

    private static boolean isValidChar(char ch) {
        if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
            return true;
        if ((ch >= 0x4e00 && ch <= 0x7fff) || (ch >= 0x8000 && ch <= 0x952f))
            return true;// 简体中文汉字编码
        return false;
    }

    /**
     * 除去数组中的空值和签名参数
     *
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    private static Map<String, String> paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<>();
        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                    || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    private static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }
}