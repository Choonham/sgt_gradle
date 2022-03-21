package com.sgt.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.sgt.crud_toy.*.*.*(..))")
    public void beforeLog(JoinPoint jp) {
        logger.info("[" + jp.getTarget().getClass().getSimpleName() + "||" + jp.getSignature().getName() + " START]");
    }

    @After("execution(* com.sgt.crud_toy.*.*.*(..))")
    public void afterLog(JoinPoint jp) {
        logger.info("[" + jp.getTarget().getClass().getSimpleName() + "||" + jp.getSignature().getName() + " END]");
    }
}
