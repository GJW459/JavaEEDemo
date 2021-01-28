package com.gjw.Interceptor;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Order(1)
@Component
/**
 * Filter主要是Servlet容器初始化的拦截的是指定请求
 * Interceptor拦截的是Controller
 * 要使拦截器生效还要在WebMvcConfigurer中配置所有的拦截器 addInterceptors
 * 处理异常 @ExceptionHandler
 */
public class LoggerInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
