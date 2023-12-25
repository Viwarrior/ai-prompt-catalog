package com.avinash.promptstore.commons.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class CustomLogEnabledAdvice {

    Logger logger = LoggerFactory.getLogger(CustomLogEnabledAdvice.class);

    @Pointcut("@annotation(CustomLogEnabled)")
    public void customLogEnabledPc(){};

    @Around("customLogEnabledPc()")
    public Object customLogEnabled(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.info("Execution time {}ms for {}", proceedingJoinPoint.getSignature(),executionTime);
        return proceed;
    }
}

