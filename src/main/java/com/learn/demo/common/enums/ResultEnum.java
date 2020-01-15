package com.learn.demo.common.enums;

/**
 * @Author ZQQ
 * @Date 2020/1/5 11:04
 */
public enum ResultEnum {

    LOGIN_SUCCESS("00000", "登陆成功"),
    LOGIN_FAIL("10000", "登陆失败");

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
