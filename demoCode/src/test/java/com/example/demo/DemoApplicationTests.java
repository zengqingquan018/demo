package com.example.demo;

import com.example.demo.service.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private DemoService demoService;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {

    }

    @Test
    public void test() {
        List<String> list = demoService.test();
        Assert.assertTrue(list.size() == 7);
    }

    @Test

    public void testTransation() {
        demoService.insertDate();
    }

    @Test
    public void getContext() throws ClassNotFoundException, NoSuchMethodException {

    }

}
