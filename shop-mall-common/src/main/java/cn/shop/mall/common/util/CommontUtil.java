package cn.shop.mall.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by LSY on 2020/11/17.
 */
public class CommontUtil {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 获取订单编号
     * @return 订单编号
     */
    public static String getOrderSn(){
        String date = format.format(new Date());
        Random random = new Random();
        return date + random.nextInt(999);
    }


    public static void main(String[] args) {
        System.out.println(getOrderSn());
    }


}
