package cn.shop.mall.common.exception;

import cn.shop.mall.common.enums.CodeMsgEnum;
import cn.shop.mall.common.enums.IResultCode;

public class BizException extends RuntimeException {

    private String code;

    private String msg;

    private Throwable throwable;

    public BizException(String msg) {
        super(msg);
        this.code = CodeMsgEnum.业务请求失败.getCode();
        this.msg = msg;
    }

    public BizException(IResultCode iResultCode) {
        super(iResultCode.getMsg());
        this.code = iResultCode.getCode();
        this.msg = iResultCode.getMsg();
    }

    public BizException() {
        super(CodeMsgEnum.业务请求失败.getMsg());
        this.code = CodeMsgEnum.业务请求失败.getCode();
        this.msg = CodeMsgEnum.业务请求失败.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
