package com.gjw.aop;

import com.gjw.Entity.User;
import com.gjw.config.AppConfig;
import com.gjw.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * OOP :面向对象编程 将系统的实体看成一个个对象 整个系统其实是对象于对象之间的交互
 * AOP :面向切面编程 把系统分解成为不同的关注点，或者称之为切面 动态将这些增强织入到切点上
 * AOP实现：运用动态代理技术 在运行过程中动态实现类的代理 增强
 * 第一种使用AspectJ的注解 配合execution()语法来装配AOP
 * 第二种使用注解来装配AOP => 类似于@Transactional注解 特殊的注释 运行中获取这个注解进行装配AOP
 *
 *
 */
public class AopTest {

    @Test
    public void test1(){

        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        UserService bean = context.getBean(UserService.class);
        bean.insert();
    }

    @Test
    public void test2(){
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        UserService bean = context.getBean(UserService.class);
        User user = bean.register("1447851361@qq.com", "123456", "gjw459");
        System.out.println(user);
    }
}
