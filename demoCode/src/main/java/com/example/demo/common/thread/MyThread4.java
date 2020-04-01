package com.example.demo.common.thread;

import com.example.demo.common.test.TestClass;
import com.example.demo.common.test.TestClass3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author ZQQ
 * @Date 2020/4/1 18:09
 */
public class MyThread4 extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(MyThread4.class);
    TestClass3 testClass = new TestClass3();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            testClass.getNext();
            testClass.getNext1();
        }
    }

}
