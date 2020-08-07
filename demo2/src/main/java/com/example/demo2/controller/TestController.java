package com.example.demo2.controller;

import com.example.demo2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/8/7 14:22
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/show")
    public String show() {
        return testService.show();
    }
}
