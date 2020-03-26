package com.example.demo.service.serviceImpl;


import com.example.demo.common.dao.UserDao;
import com.example.demo.common.enums.ResultCode;
import com.example.demo.common.enums.ResultEnum;
import com.example.demo.common.exception.DemoException;
import com.example.demo.common.response.ResponseResult;
import com.example.demo.mapper.DemoMapper;
import com.example.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    private final static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ApplicationContext applicationContext;


    /**
     * 数据连接和redis测试
     *
     * @param
     * @return java.lang.String
     * @author ZQQ
     * @date 2020/1/5
     */
    @Override
    public List<String> test() {
        List<String> result = demoMapper.test();
        logger.info("=========" + result);
        redisTemplate.opsForValue().set("test", "test");
        return result;
    }

    @Override
    public ResponseResult<String> login(UserDao userDao, HttpServletRequest request) {
        if (StringUtils.isEmpty(userDao.getUsername()) || StringUtils.isEmpty(userDao.getPassword())) {
            return new ResponseResult<>(ResultCode.FAIL_CODE, "用户名密码为空", null);
        }
        if (!("test".equals(userDao.getUsername()) && "test".equals(userDao.getPassword()))) {
            throw new DemoException("用户名或密码错误");
        }
        //session重置
        request.getSession().invalidate();
        request.getSession().setAttribute("userName", userDao.getUsername());
        return new ResponseResult<>(ResultCode.SUCCESS_CODE, ResultEnum.LOGIN_SUCCESS.getMsg(), null);
    }

    @Override
    public void getContext() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (int i = 1; i < beanNames.length; i++) {
            logger.info("{}:beanName:{}", i + 1, beanNames[i]);
        }
    }
}
