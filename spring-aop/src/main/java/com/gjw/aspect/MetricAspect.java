package com.gjw.aspect;

import com.gjw.Annotaion.MetricTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricAspect {

    @Around("@annotation(metricTime)")
    public Object metric(ProceedingJoinPoint joinPoint, MetricTime metricTime) throws Throwable {
        String value = metricTime.value();
        long start = System.currentTimeMillis();
        try {
            return  joinPoint.proceed();
        }finally {

            long time = System.currentTimeMillis()-start;
            //写日志或者发送给JMX
            System.err.println("[Metrics]"+value+":"+time+"ms");
        }
    }
}
