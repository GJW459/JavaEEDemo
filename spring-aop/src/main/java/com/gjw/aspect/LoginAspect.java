package com.gjw.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 */
@Component
@Aspect
public class LoginAspect {

    @Pointcut("execution(public * com.gjw.service.UserService.*(..))")
    public void pointCut1(){

    }

    /**
     * 前置增强 将需要代理的类拦截然后进行增强
     */
    @Before("pointCut1()")
    public void doAccessCheck(){
        System.err.println("[Before] do access check..");
    }
    @Around("pointCut1()")
    public Object doLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        System.err.println("[Around] start"+joinPoint.getSignature());
        Object proceed = joinPoint.proceed();
        System.err.println("[Around] start"+joinPoint.getSignature());
        return proceed;
    }

}
