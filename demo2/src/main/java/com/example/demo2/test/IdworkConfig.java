package com.example.demo2.test;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/7/20 11:21
 */
@Component
public class IdworkConfig {

    @Autowired
    private Config config;

    private IdWorker idWorker;

    @PostConstruct
    public void init() {
        idWorker = new IdWorker(config.getWorkId(), config.getDatacenterId(), 1);
    }

    public Long nextId() {
        return idWorker.nextId();
    }

}
