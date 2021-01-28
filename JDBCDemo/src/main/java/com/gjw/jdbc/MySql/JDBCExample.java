package com.gjw.jdbc.MySql;

import com.gjw.jdbc.entity.User;

import java.sql.*;

public class JDBCExample {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
            String url = "jdbc:mysql://localhost:3306/practice?useSSL=false&&serverTimezone=UTC";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return connection;

    }

    public static User getUser(){

        Connection connection = JDBCExample.getConnection();
        PreparedStatement statement=null;
        ResultSet set=null;
        try {
            statement=connection.prepareStatement("select * from user ");
            set=statement.executeQuery();
            while (set.next())
            {
                int id = set.getInt("id");
                String name = set.getString("name");
                User user = new User();
                user.setId(id);
                user.setName(name);
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        finally {
            if (set!=null) {
                try {
                    set.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement!=null)
            {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection!=null)
            {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
        return null;
    }
}
