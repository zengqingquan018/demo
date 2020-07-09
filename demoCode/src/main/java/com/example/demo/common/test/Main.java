package com.example.demo.common.test;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.utils.DateUtils;
import com.example.demo.mapper.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/7/3 16:34
 */
public class Main {


    /**
     * 定义一个全局的 SimpleDateFormat
     */
/*
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
*/

    private static ExecutorService pool = new ThreadPoolExecutor(5, 200, 0L,
            TimeUnit.MILLISECONDS, new ArrayBlockingQueue(10));
    /**
     * 定义一个 CountDownLatch，保证所有子线程执行完之后主线程再执行
     */
    private static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {
      /*  // 定义一个线程安全的 HashSet
        Set<String> dates = Collections.synchronizedSet(new HashSet<String>());
        for (int i = 0; i < 100; i++) {            // 获取当前时间
            Calendar calendar = Calendar.getInstance();
            int finalI = i;
            pool.execute(() -> {                    // 时间增加
                calendar.add(Calendar.DATE, finalI);
                // 通过 simpleDateFormat 把时间转换成字符串
                String dateString = DateUtils
                        .format(calendar.getTime(),"yyyy-MM-dd HH:mm:ss");                    // 把字符串放入 Set 中
                dates.add(dateString);
                //countDown
                countDownLatch.countDown();
            });
        }        // 阻塞，直到 countDown 数量为 0
        countDownLatch.await();        // 输出去重后的时间个数
        System.out.println(dates.size());*/

        Test3 test3 = new Test3(3);
        test3.show();
    }

}
