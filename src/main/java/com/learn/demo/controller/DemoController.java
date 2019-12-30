package com.learn.demo.controller;

import com.learn.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    @GetMapping("/test")
    public String test() {
        return  demoService.test();
    }
}
