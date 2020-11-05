package cn.shop.mall.common.vo;

import cn.shop.mall.common.enums.CodeMsgEnum;

import java.io.Serializable;

public class ResponseVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private T data;

    private String msg;

    public Boolean isSuccess() {
        return code.equals(CodeMsgEnum.请求成功.getCode());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static <T> ResponseVO<T> SUCCESS(T data) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setCode(CodeMsgEnum.请求成功.getCode());
        responseVO.setMsg(CodeMsgEnum.请求成功.getMsg());
        responseVO.setData(data);
        return responseVO;
    }

    public static <T> ResponseVO<T> SUCCESS() {
        ResponseVO<T> responseVO = new ResponseVO<T>();
        responseVO.setCode(CodeMsgEnum.请求成功.getCode());
        responseVO.setMsg(CodeMsgEnum.请求成功.getMsg());
        return responseVO;
    }

    public static <T> ResponseVO<T> FAIL(CodeMsgEnum codeMsgEnum) {
        ResponseVO<T> responseVO = new ResponseVO<T>();
        responseVO.setCode(codeMsgEnum.getCode());
        responseVO.setMsg(codeMsgEnum.getMsg());
        return responseVO;
    }

    public static <T> ResponseVO<T> FAIL(String msg) {
        ResponseVO<T> responseVO = new ResponseVO<T>();
        responseVO.setCode(CodeMsgEnum.业务请求失败.getCode());
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static <T> ResponseVO<T> FAIL(String code, String msg) {
        ResponseVO<T> responseVO = new ResponseVO<T>();
        responseVO.setCode(code);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static <T> ResponseVO<T> ERROR() {
        ResponseVO<T> responseVO = new ResponseVO<T>();
        responseVO.setCode(CodeMsgEnum.系统繁忙请稍后重试.getCode());
        responseVO.setMsg(CodeMsgEnum.系统繁忙请稍后重试.getMsg());
        return responseVO;
    }

}
