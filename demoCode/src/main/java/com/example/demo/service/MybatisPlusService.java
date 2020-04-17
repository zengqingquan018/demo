package com.example.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.mapper.Test;

import java.util.List;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/4/16 17:50
 */
public interface MybatisPlusService {
    Test getByid(String id);

    void add();
}
