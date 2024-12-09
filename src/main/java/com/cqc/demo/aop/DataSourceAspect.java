package com.cqc.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

    @Before("@annotation(com.cqc.demo.annotation.ReadOnly)")
    public void setReadDataSource() {
        DataSourceContextHolder.setDataSource("secondary");
    }

    @Before("@annotation(com.cqc.demo.annotation.WriteOnly)")
    public void setWriteDataSource() {
        DataSourceContextHolder.setDataSource("primary");
    }

    @After("execution(* com.cqc.demo..*(..))")
    public void clearDataSource() {
        DataSourceContextHolder.clearDataSource();
    }
}

