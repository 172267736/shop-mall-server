package cn.shop.mall.common.enums;

public enum CodeMsgEnum implements IResultCode {

    请求成功("000000", "请求成功"),

    业务请求失败("100000", "业务请求失败"),

    参数有误("100001", "参数有误"),

    请登录("100002", "请登录"),

    账号密码有误("100003", "账号密码有误"),

    无权限请联系管理员("100004", "无权限请联系管理员"),

    系统繁忙请稍后重试("999999", "系统繁忙,请稍后重试");

    private String code;

    private String msg;

    CodeMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
