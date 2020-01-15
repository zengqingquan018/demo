package com.learn.demo.controller;

import com.learn.demo.common.dao.UserDao;
import com.learn.demo.common.response.ResponseResult;
import com.learn.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user/")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * 项目搭建测试
     *
     * @param
     * @return java.lang.String
     * @author ZQQ
     * @date 2020/1/5
     */
    @GetMapping("/test")
    public String test() {
        return demoService.test();
    }

    /**
     * 登陆
     *
     * @param userDao
     * @return com.learn.demo.common.response.ResponseResult<java.lang.String>
     * @author ZQQ
     * @date 2020/1/5
     */
    @PostMapping("/login")
    public ResponseResult<String> login(@RequestBody UserDao userDao,HttpServletRequest request) {
        return demoService.login(userDao,request);
    }
}
