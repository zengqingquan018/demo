package com.learn.demo.service.serviceImpl;

import com.learn.demo.mapper.DemoMapper;
import com.learn.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    private final static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public String test() {

        String result = demoMapper.test();
        logger.info("========="+result);
        return result;
    }
}
