package cn.shop.mall.common.enums;

public enum EventSourceEnum {

    浏览器("browser", "浏览器"),

    安卓("android", "安卓"),

    苹果("ios", "苹果"),

    服务端("server", "服务端");

    private String tag;

    private String msg;

    EventSourceEnum(String tag, String msg) {
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
