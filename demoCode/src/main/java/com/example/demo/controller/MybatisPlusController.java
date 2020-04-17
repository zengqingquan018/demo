package com.example.demo.controller;

import com.example.demo.mapper.Test;
import com.example.demo.service.MybatisPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/4/16 17:49
 */
@RequestMapping("/mybatisPlus")
@RestController
public class MybatisPlusController {

    @Autowired
    private MybatisPlusService mybatisPlusService;

    @GetMapping("/query")
    public Test query(String test) {
        return mybatisPlusService.getByid(test);
    }

    @GetMapping("/add")
    public void add() {
        mybatisPlusService.add();


    }
}
