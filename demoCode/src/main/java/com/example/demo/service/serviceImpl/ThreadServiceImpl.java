package com.example.demo.service.serviceImpl;

import com.example.demo.common.test.TestClass;
import com.example.demo.common.test.TestClass1;
import com.example.demo.common.thread.*;
import com.example.demo.service.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @Author ZQQ
 * @Date 2020/3/31 19:47
 */
public class ThreadServiceImpl implements ThreadService {
    private Logger logger = LoggerFactory.getLogger(ThreadServiceImpl.class);

    @Override
    public void testThread() {
        //线程
        Thread thread1 = new Thread(new MyThread(1));
        Thread thread2 = new Thread(new MyThread1(2));

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

        //三个线程的线程池，五个线程 另外两个需要等待，
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(thread2);
            logger.info("活动线程数：{}，排队线程数：{}", ((ThreadPoolExecutor) fixedThreadPool).getActiveCount(),
                    ((ThreadPoolExecutor) fixedThreadPool).getQueue().size());
        }

        //单个线程的线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            singleThreadExecutor.execute(thread2);
        }
        //两个线程的定时线程池，5s后执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        logger.info("time:{}", System.currentTimeMillis());
        scheduledThreadPool.schedule(thread1, 5, TimeUnit.SECONDS);

        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    }

    //验证synchronize
    @Override
    public void testLock() {
        TestClass testClass = new TestClass();
        TestClass1 testClass1 = new TestClass1();
        MyThread2 myThread2 = new MyThread2(testClass);
        MyThread2 myThread21 = new MyThread2(testClass);
        MyThread3 myThread3 = new MyThread3(testClass1);
        MyThread3 myThread31 = new MyThread3(testClass1);
        myThread2.start();
        myThread21.start();
        myThread3.start();
        myThread31.start();
    }


    public void testThreadLocal() {
        MyThread4 myThread4 = new MyThread4();
        MyThread4 myThread41 = new MyThread4();
        MyThread4 myThread42 = new MyThread4();
        myThread4.start();
        myThread41.start();
        myThread42.start();
    }

    public static void main(String[] args) {
        ThreadService threadService = new ThreadServiceImpl();
        threadService.testThreadLocal();
    }
}
