package com.example.demo.common.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author ZQQ
 * @Date 2020/4/1 16:54
 */
public class TestClass {
    private static final Logger logger = LoggerFactory.getLogger(TestClass.class);

    public synchronized void testMethod() {
        logger.info("this is synchronized testMethod,time:{}", System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("==========error===========");
        }
    }

}
