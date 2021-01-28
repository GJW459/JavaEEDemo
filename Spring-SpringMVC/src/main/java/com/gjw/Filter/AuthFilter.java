package com.gjw.Filter;


import com.gjw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 还需要在web.xml中配置一个DelegatingFilterProxy
 * 实现原理：
 * 1.servlet容器从web.xml中读取配置，实例化DelegatingFilterProxy，注意命名为authFilter
 * 2.Spring容器通过扫描@Component实例化AuthFilter
 *
 */
@Component
public class AuthFilter implements Filter {

    @Autowired
    private UserService userService;
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        //如果允许用户使用Basic模式进行用户验证，在HTTP请求中添加请求头Authorization:Basic email:password
        HttpServletRequest req = (HttpServletRequest) request;
        //获取Authorization头
        String header = req.getHeader("Authorization");
        if (header!=null&&header.startsWith("Basic")){
            //从Header中提取email和password

        }
        //继续处理请求
        filterChain.doFilter(request,response);
    }
}
