package com.gjw.service;

import com.gjw.dao.UserMapper;
import com.gjw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public List<User> getAllUsers(){

        List<User> users = userMapper.findAllUsers();
        return users;
    }

    @Transactional
    public User getUserById(Integer id){

        User user = userMapper.findUserById(id);
        return user;
    }
}
