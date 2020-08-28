package com.example.demo2.test;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/7/20 11:11
 */
@Component
@ConfigurationProperties(prefix = "snow")
public class Config {

    private int workId;

    private int datacenterId;

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public int getDatacenterId() {
        return datacenterId;
    }

    public void setDatacenterId(int datacenterId) {
        this.datacenterId = datacenterId;
    }
}
