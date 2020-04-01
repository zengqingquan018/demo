package com.example.demo.common.test;

import com.example.demo.common.thread.MyThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author ZQQ
 * @Date 2020/4/1 16:54
 */
public class TestClass3 {
    private static final Logger logger = LoggerFactory.getLogger(TestClass3.class);
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        // 覆盖初始化方法
        public Integer initialValue() {
            return 0;
        }
    };

    private static int a;

    public void getNext() {
        threadLocal.set(threadLocal.get() + 1);
        logger.info("ThreadLocal:{}", (threadLocal.get()));
    }

    public void getNext1() {
        a++;
        logger.info("int:{}", a);
    }
}
