package com.example.demo.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author ZQQ
 * @Date 2020/3/26 16:52
 */
@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Pointcut("@annotation(com.example.demo.common.aop.Operation)")
    private void logPoint() {
    }


    @Around("logPoint()&&@annotation(operation)")
    public Object OperationLog(ProceedingJoinPoint point, Operation operation) {
        logger.info("==========start=======");
        logger.info("方法作用：{}", operation.value());
        Object result = null;

        try {
            result = point.proceed();
            logger.info("========end==========");
        } catch (Throwable e) {
            logger.error("error:{}", e.getMessage());
        }
        return result;
    }
}
