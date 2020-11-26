package cn.shop.mall.common.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by LSY on 2020/11/23.
 */
public enum TagEnum {

    HOME(1, "家"), COMPANY(2, "公司");

    private Integer code;

    private String msg;

    TagEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static List<String> getTags(){
        return Arrays.stream(TagEnum.values()).map(tag->tag.getMsg()).collect(Collectors.toList());
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
