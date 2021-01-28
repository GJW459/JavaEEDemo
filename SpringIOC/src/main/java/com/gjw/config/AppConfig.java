package com.gjw.config;


import com.gjw.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.gjw")
public class AppConfig {


    @Bean("person")
    @Scope("prototype")
    public Person person(){

        Person person = new Person();
        person.setAge(15);
        person.setId(1);
        person.setName("郭经伟");
        return person;
    }
}
