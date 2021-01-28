package com.gjw.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Spring整合MyBatis主要是创建SqlSessionFactory=>创建SqlSession MapperScan=>
 * MyBatis也可以直接使用Spring声明式事务
 */
@Configuration
@PropertySource("jdbc.properties")
@ComponentScan("com.gjw")
@EnableTransactionManagement
@MapperScan("com.gjw.dao")//MyBatis提供了一个MapperFactoryBean来自动创建所有的Mapper的实现类
public class AppConfig {

    @Value("${jdbc.url}")
    String jdbcUrl;
    @Value("${jdbc.driverName}")
    String driverName;
    @Value("${jdbc.userName}")
    String username;
    @Value("${jdbc.password}")
    String password;

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setDriverClassName(driverName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    PlatformTransactionManager transactionManager(@Autowired DataSource dataSource){

        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }



}
