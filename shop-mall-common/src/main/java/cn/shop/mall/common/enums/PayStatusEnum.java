package cn.shop.mall.common.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by LSY on 2020/11/23.
 */
public enum PayStatusEnum {

    UNPAID(0, "待支付"), PAYING(1, "支付中"), PAY_SUCCESS(2, "支付成功"), PAY_FAIL(3, "支付失败");

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
