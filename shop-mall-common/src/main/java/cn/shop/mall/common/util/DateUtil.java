package cn.shop.mall.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间字符串转日期对象
     * @param time 时间字符串
     */
    public static Date parse(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(YYYYMMDDHHMMSS);
            return format.parse(time);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 日期对象转时间字符串
     * @param date 日期对象
     */
    public static String parseDate(Date date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(YYYYMMDDHHMMSS);
            return format.format(date);
        } catch (Exception e) {
            return null;
        }
    }

}
