package com.gjw.jdbc.MySql;

import com.gjw.jdbc.entity.User;

public class JDBCTest {

    public static void main(String[] args) {

        User user = JDBCExample.getUser();
        System.out.println(user);
    }
}
