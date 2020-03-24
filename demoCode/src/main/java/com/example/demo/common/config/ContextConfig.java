package com.example.demo.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ZQQ
 * @Date 2020/3/24 17:13
 */
@Configuration
public class ContextConfig implements ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(ContextConfig.class);
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void getApplicationContext() {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            logger.info("{}:{}", i, names[i]);
        }
    }
}
