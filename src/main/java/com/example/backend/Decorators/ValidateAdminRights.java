package com.example.backend.Decorators;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidateAdminRights {
    @Around("@annotation(IAdminRights)")
    public Object validateAdminRights(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(">>> Before method: ");

        Object result = joinPoint.proceed();

        return result;
    }
}
