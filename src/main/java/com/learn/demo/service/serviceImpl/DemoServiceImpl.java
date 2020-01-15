package com.learn.demo.service.serviceImpl;

import com.learn.demo.common.dao.UserDao;
import com.learn.demo.common.enums.ResultCode;
import com.learn.demo.common.enums.ResultEnum;
import com.learn.demo.common.exception.DemoException;
import com.learn.demo.common.response.ResponseResult;
import com.learn.demo.mapper.DemoMapper;
import com.learn.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

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

    @Override
    public ResponseResult<String> login(UserDao userDao,HttpServletRequest request) {
        if (StringUtils.isEmpty(userDao.getUsername()) || StringUtils.isEmpty(userDao.getPassword())) {
            return new ResponseResult<>(ResultCode.FAIL_CODE, "用户名密码为空", null);
        }
        if (!("test".equals(userDao.getUsername()) && "test".equals(userDao.getPassword()))) {
            throw new DemoException("用户名或密码错误");
        }
        //session重置
        request.getSession().invalidate();
        request.getSession().setAttribute("userName",userDao.getUsername());
        return new ResponseResult<>(ResultCode.SUCCESS_CODE, ResultEnum.LOGIN_SUCCESS.getMsg(), null);
    }
}
