package com.gjw.controller;

import com.gjw.entity.User;
import com.gjw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest方式开发接口 返回接收JSON数据
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        return user;
    }
}
