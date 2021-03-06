package com.example.demo.common.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Author ZQQ
 * @Date 2020/3/31 19:43
 */
public class MyThread implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(MyThread.class);

    private int number;

    public MyThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        logger.info("start ,thread name:{}thread num :{}，time：{}", Thread.currentThread().getName(), number, System.currentTimeMillis());

    }
}
