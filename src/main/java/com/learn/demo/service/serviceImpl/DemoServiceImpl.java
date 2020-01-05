package com.learn.demo.service.serviceImpl;

import com.learn.demo.mapper.DemoMapper;
import com.learn.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    private final static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 数据连接和redis测试
     * @author ZQQ
     * @date 2020/1/5
      * @param
     * @return java.lang.String
     */
    @Override
    public String test() {
        String result = demoMapper.test();
        logger.info("=========" + result);
        redisTemplate.opsForValue().set("test","test");
        return result;
    }
}
