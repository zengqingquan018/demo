package com.example.demo;

import com.example.demo.service.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public  class DemoApplicationTests {
    @Autowired
    private DemoService demoService;

    @Test
    public void contextLoads() {

    }

    @Test
   public void test() {
        List<String> list = demoService.test();
        Assert.assertTrue(list.size() == 7);
    }
}
