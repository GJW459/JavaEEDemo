package com.gjw.jdbc;

import com.gjw.config.AppConfig;
import com.gjw.entity.User;
import com.gjw.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class JdbcTest {


    @Test
    public void test1(){

        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        List<User> users = userService.findAllUsers();
        for(User user:users){
            System.out.println(user);
        }

    }
}
