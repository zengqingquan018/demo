package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.mapper.Test;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.MybatisPlusService;
import org.apache.tools.ant.taskdefs.Tstamp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/4/16 17:50
 */
@Service
public class MybatisPlusServiceImpl implements MybatisPlusService {

    @Override
    public Test getByid(String id) {
        Test entity = new Test();
        Test test = entity.selectById(id);
        return test;

    }

    @Override
    public void add() {
        Test entity = new Test();
        entity.setTest("test");
        entity.setTest1("test1");
        entity.insert();
    }
}
