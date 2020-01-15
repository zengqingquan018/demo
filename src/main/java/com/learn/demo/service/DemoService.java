package com.learn.demo.service;

import com.learn.demo.common.dao.UserDao;
import com.learn.demo.common.response.ResponseResult;

import javax.servlet.http.HttpServletRequest;

public interface DemoService {
    String test();

    ResponseResult<String> login(UserDao userDao, HttpServletRequest request);
}
