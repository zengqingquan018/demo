package com.example.demo.controller;


import com.example.demo.common.aop.Operation;
import com.example.demo.common.config.ContextConfig;
import com.example.demo.common.dao.UserDao;
import com.example.demo.common.enums.ResultCode;
import com.example.demo.common.enums.ResultEnum;
import com.example.demo.common.response.ResponseResult;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private ContextConfig contextConfig;


    /**
     * 项目搭建测试
     *
     * @param
     * @return java.lang.String
     * @author ZQQ
     * @date 2020/1/5
     */
    @GetMapping("/test")
    public ResponseResult<List<String>> test() {
        return new ResponseResult<>(ResultCode.SUCCESS_CODE, "success", demoService.test());
    }


    @Operation(value = "TEST")
    @GetMapping("/getContext")
    public void getContext() {
        demoService.getContext();
    }


    @GetMapping("/testTransaction")
    public ResponseResult<String> testTransaction() {
        demoService.insertDate();
        return new ResponseResult<>("10000", "success", null);

    }

    /**
     * 登陆
     *
     * @param
     * @return com.learn.demo.common.response.ResponseResult<java.lang.String>
     * @author ZQQ
     * @date 2020/1/5
     */
    @GetMapping("/login")
    public ResponseResult<String> login(HttpServletRequest request) {
        UserDao userDao = new UserDao();
        userDao.setUsername(request.getParameter("username"));
        userDao.setPassword(request.getParameter("password"));
        return demoService.login(userDao, request);
    }
}
