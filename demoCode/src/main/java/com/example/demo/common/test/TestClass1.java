package com.example.demo.common.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author ZQQ
 * @Date 2020/4/1 16:54
 */
public class TestClass1 {
    private static final Logger logger = LoggerFactory.getLogger(TestClass1.class);

    public void testMethod() {
        logger.info("this is testMethod,time:{}", System.currentTimeMillis());
    }

}
