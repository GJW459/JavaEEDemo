package com.gjw.ioc;


import com.gjw.config.AppConfig;
import com.gjw.entity.Person;
import com.gjw.service.AppService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC 也就是反正控制 将bean 对象的控制权交给Spring管理
 * DI 依赖注入 将实例注入IOC容器
 * 使用spring ioc 的优点：解耦合
 * 使用ioc的两个方式：一个XML配置文件 JavaConfig方式 自动装配（自动注入到ioc容器中）
 */
public class SpringIOCTest {




    @Test
    public void test1(){

        // ioc容器 ApplicationContext和 BeanFactory 区别 BeanFactory懒加载
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-ioc.xml");
        Person person = (Person) context.getBean("person1");
        Person person2 = (Person) context.getBean("person1");
        System.out.println(person==person2);

    }

    @Test
    public void test2(){

        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = (Person) context.getBean("person");
        Person person2 = (Person) context.getBean("person");
        System.out.println(person==person2);
    }

}
