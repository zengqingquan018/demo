package com.example.demo.service.serviceImpl;

import com.example.demo.common.thread.MyThread;
import com.example.demo.service.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Executable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author ZQQ
 * @Date 2020/3/31 19:47
 */
public class ThreadServiceImpl implements ThreadService {
    private Logger logger = LoggerFactory.getLogger(ThreadServiceImpl.class);

    @Override
    public void myThreadTest() {
        //线程
        Thread thread1 = new Thread(new MyThread(1));
        Thread thread2 = new Thread(new MyThread(2));
        Thread thread3 = new Thread(new MyThread(3));
        /*thread1.start();
        thread2.start();
        thread3.start();*/

        //可缓存线程池,第一个任务执行完毕后，第二个任务可以直接使用第一个任务的线程,线程池无限大
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
     //确认前一个线程执行完毕
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                logger.error("Thread sleep error:{}", e);
            }
            cachedThreadPool.execute(thread1);
            logger.info("活动线程数：{}，排队线程数：{}", ((ThreadPoolExecutor) cachedThreadPool).getActiveCount(),
                    ((ThreadPoolExecutor) cachedThreadPool).getQueue().size());
        }

        //两个线程的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(thread1);
            logger.info("活动线程数：{}，排队线程数：{}", ((ThreadPoolExecutor) fixedThreadPool).getActiveCount(),
                    ((ThreadPoolExecutor) fixedThreadPool).getQueue().size());
        }

        //单个线程的线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        //两个核心的定时
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);


    }

    public static void main(String[] args) {
        ThreadService threadService = new ThreadServiceImpl();
        threadService.myThreadTest();
    }
}
