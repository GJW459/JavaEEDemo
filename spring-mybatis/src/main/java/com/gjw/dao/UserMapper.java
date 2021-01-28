package com.gjw.dao;

import com.gjw.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> findAllUsers();
}
