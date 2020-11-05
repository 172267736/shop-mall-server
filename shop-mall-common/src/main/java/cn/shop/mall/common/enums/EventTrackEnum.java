package cn.shop.mall.common.enums;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public enum  EventTrackEnum {

    客户端登录("admin_login", "客户端登录");

    private String tag;

    private String msg;

    EventTrackEnum(String tag, String msg) {
        this.tag = tag;
        this.msg = msg;
    }

    public String getTag() {
        return tag;
    }

    public String getMsg() {
        return msg;
    }
}
