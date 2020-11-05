package cn.shop.mall.common.enums;

public enum BooleanEnum {

    否(0, false, "否"),

    是(1, true, "是");

    private Integer code;

    private Boolean type;

    private String msg;

    BooleanEnum(Integer code, Boolean type, String msg) {
        this.code = code;
        this.type = type;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public Boolean getType() {
        return type;
    }

    public String getMsg() {
        return msg;
    }
}
