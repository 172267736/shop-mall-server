package cn.shop.mall.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class BeanCopyUtil {

    public static <T> T copyBean(Object source, Class<T> cls) {
        try {
            T t = cls.newInstance();
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (Exception var4) {
            return null;
        }
    }

    public static <T> List<T> copyBeans(List<?> source, Class<T> cls) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        } else {
            List<T> list = new ArrayList<>();
            source.forEach((o) -> {
                list.add(copyBean(o, cls));
            });
            return list;
        }
    }
}
