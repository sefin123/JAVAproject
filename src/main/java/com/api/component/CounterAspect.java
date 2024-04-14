package com.api.component;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class CounterAspect {

    private final RequestCounter requestCounter;

    public CounterAspect(RequestCounter requestCounter) {
        this.requestCounter = requestCounter;
    }

    @Pointcut("execution(* com.api.controller.*.post*(..))")
    public void create() {

    }

    @Pointcut("execution(* com.api.controller.*.get*(..))")
    public void getEntity() {

    }

   @Pointcut("execution(* com.api.controller.*.put*(..))")
    public void put() {

    }

    @Pointcut("execution(* com.api.controller.*.delete*(..))")
    public void delete() {

    }

    @Pointcut("execution(* com.api.exception.*.handle*(..))")
    public void handle() {

    }

    @After("create() || getEntity() || put() || delete() || handle()")
    void countRequest() {
        requestCounter.incrementAndGet();
    }

    @PreDestroy
    void logCount() {
        log.info("Total request count {}", requestCounter.getCounter());
    }
}
