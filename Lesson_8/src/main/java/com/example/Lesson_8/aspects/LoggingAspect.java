package com.example.Lesson_8.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());


    @AfterReturning(value = "@annotation(ToLogAfter)", returning = "returnedValue")
    public Object logAfter(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodSignature = joinPoint.getSignature().getName();
        System.out.println("Method " + methodSignature + " executed");
        return joinPoint.proceed();
    }


    @Around(value = "@annotation(ToLogAround)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodSignature = joinPoint.getSignature().getName();
        System.out.println("Method " + methodSignature + " will execute");
        System.out.println("Method " + methodSignature + " has been executed");
        return joinPoint.proceed();
    }
}
