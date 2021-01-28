package com.gjw.service;

import com.gjw.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @Transactional 声明式事务 原理是使用AOP代理 自动创建代理类
     * @return
     */
    @Transactional
    public List<User> findAllUsers(){

        List<User> users = jdbcTemplate.query("select * from user;", new RowMapper<User>() {

            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        });
        return users;
    }
}
