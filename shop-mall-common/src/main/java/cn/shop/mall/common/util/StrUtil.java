package cn.shop.mall.common.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {

    /**
     * 生成uuid
     */
    public static String buildUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 返回指定字符在字符串中第n次出现的位置
     */
    public static int getCharacterPosition(String str, String character, int n) {
        Matcher slashMatcher = Pattern.compile(character).matcher(str);
        int mIdx = 0;
        while (slashMatcher.find()) {
            mIdx++;
            if (mIdx == n) {
                break;
            }
        }
        return slashMatcher.start();
    }

}
