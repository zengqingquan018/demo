package com.example.demo.common.thread;

import com.example.demo.common.test.TestClass;
import com.example.demo.common.test.TestClass1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author ZQQ
 * @Date 2020/4/1 16:51
 */
public class MyThread3 extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(MyThread3.class);
    private TestClass1 testClass1;

    public MyThread3(TestClass1 testClass1) {
        this.testClass1 = testClass1;
    }


    @Override
    public void run() {
        testClass1.testMethod();
    }
}
