package com.example.demo2.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/7/20 10:46
 */
public class Thread {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        IdWorker worker = new IdWorker(1, 1, 1);


    }

}
