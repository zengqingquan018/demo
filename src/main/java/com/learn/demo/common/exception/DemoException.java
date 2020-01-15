package com.learn.demo.common.exception;

import com.learn.demo.common.enums.ResultCode;

/**
 * @Author ZQQ
 * @Date 2020/1/5 13:53
 */
public class DemoException extends RuntimeException {

    private String code;

    public DemoException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public DemoException(String message) {
        super(message);
        this.code = ResultCode.FAIL_CODE;
    }
}
