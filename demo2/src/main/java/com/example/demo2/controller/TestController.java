package com.example.demo2.controller;

import com.example.demo2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/8/7 14:22
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Value("${type}")
    private String type;

    @GetMapping("/getType")
    public String getType() {
        return type;
    }

    @GetMapping("/show")
    public String show() {
        return testService.show();
    }


}
