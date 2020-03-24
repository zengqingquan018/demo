package com.example.demo.common.exception;

import com.example.demo.common.enums.ResultCode;
import com.example.demo.common.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ZQQ
 * @Date 2020/1/5 13:57
 */
@ControllerAdvice
public class DemoExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(DemoExceptionHandler.class);

    /**
     * 全局异常拦截 Controller
     *
     * @param e
     * @param request
     * @param response
     * @return com.learn.demo.common.response.ResponseResult
     * @author ZQQ
     * @date 2020/1/5
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseResult result(Exception e, HttpServletRequest request, HttpServletResponse response) {
        if (e instanceof DemoException) {
            logger.info("自定义异常:{}",e);
            return new ResponseResult(((DemoException) e).getCode(), e.getMessage(), null);
        } else {
            logger.info("其他异常:{}",e);
            return new ResponseResult(ResultCode.FAIL_CODE, e.getMessage(), null);
        }
    }
}
