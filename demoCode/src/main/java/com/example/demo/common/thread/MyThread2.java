package com.example.demo.common.thread;

import com.example.demo.common.test.TestClass;
import com.example.demo.common.test.TestClass1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author ZQQ
 * @Date 2020/4/1 16:51
 */
public class MyThread2 extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(MyThread2.class);
    private TestClass testClass;

    public MyThread2(TestClass testClass) {
        this.testClass = testClass;

    }


    @Override
    public void run() {
        testClass.testMethod();
    }
}
