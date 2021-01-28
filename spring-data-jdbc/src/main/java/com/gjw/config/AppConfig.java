package com.gjw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Spring使用声明式事务 Spring提供了一个PlatformTransactionManager来表示事务管理器 所有的事务都由它负责管理
 * 而事务由TransactionStatus表示
 * Java EE 除了提供JDBC事务外，还提供了JTA 分布式事务
 */
@Configuration
@ComponentScan("com.gjw")
@PropertySource("jdbc.properties")//导入数据库配置文件
@EnableTransactionManagement//开启声明式事务 使用@Transactional注解就OK了 声明了此注解就不用声明@EnableAspectJAutoProxy
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
    PlatformTransactionManager createTxManager(@Autowired DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    DataSource createDataSource(){
        // 创建数据源 数据库连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }

    /**
     * 使用JDBCTemplate去访问数据库
     * @return
     */
    @Bean
    JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource){

        return new JdbcTemplate(dataSource);
    }
}
