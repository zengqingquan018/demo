package com.example.demo2.service.impl;

import com.example.demo2.service.TestService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/8/7 14:23
 */
@Service
@ConditionalOnProperty(prefix = "platform", name = "type", havingValue = "SAAS")
public class TestServiceImpl implements TestService {

    @Override
    public String show() {
        return "SaaS";
    }
}
