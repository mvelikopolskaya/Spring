package com.example.Lesson_12_1.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around(value = "@annotation(ToLogAround)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodSignature = joinPoint.getSignature().getName();
        System.out.println("Method " + methodSignature + " will execute");
        Object result = joinPoint.proceed();
        System.out.println("Method " + methodSignature + " has been executed");
        return result;
    }
}
