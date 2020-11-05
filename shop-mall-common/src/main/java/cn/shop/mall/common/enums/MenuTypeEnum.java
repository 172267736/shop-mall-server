package cn.shop.mall.common.enums;

public enum MenuTypeEnum {

    根菜单(1, "根菜单"),

    子菜单(2, "子菜单"),

    接口(3, "接口");

    private Integer code;

    private String msg;

    MenuTypeEnum(Integer code, String msg) {
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
