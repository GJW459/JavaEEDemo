package com.gjw.service;

import com.gjw.Annotaion.MetricTime;
import com.gjw.Entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private User user;

    public void insert(){

        System.out.println("插入person1");
    }

    @MetricTime("register")
    public User register(String email,String password,String name){

        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return user;
    }
}
