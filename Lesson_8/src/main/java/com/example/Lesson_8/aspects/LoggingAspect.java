package com.example.Lesson_8.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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
