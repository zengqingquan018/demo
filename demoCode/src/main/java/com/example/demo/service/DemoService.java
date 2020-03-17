package com.example.demo.service;

import com.example.demo.common.dao.UserDao;
import com.example.demo.common.response.ResponseResult;
import javax.servlet.http.HttpServletRequest;

public interface DemoService {
    String test();

    ResponseResult<String> login(UserDao userDao, HttpServletRequest request);
}
