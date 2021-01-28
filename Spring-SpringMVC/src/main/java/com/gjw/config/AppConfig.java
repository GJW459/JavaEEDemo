package com.gjw.config;


import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ServletLoader;
import com.mitchellbosecke.pebble.spring.extension.SpringExtension;
import com.mitchellbosecke.pebble.spring.servlet.PebbleViewResolver;
import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
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
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.io.File;

@Configuration
@PropertySource("classpath:jdbc.properties")
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.gjw")
@MapperScan("com.gjw.dao")
public class AppConfig {


    @Value("${jdbc.userName}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driverName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;

    /**
     * 配置数据库数据源
     * @return
     */
    @Bean
    DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        return dataSource;
    }

    /**
     * 配置事务
     * @param dataSource
     * @return
     */
    @Bean
    PlatformTransactionManager transactionManager(@Autowired DataSource dataSource){

        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    /**
     * 配置SqlSessionFactory=>连接池 获取SqlSession=>Connection
     * Spring整合MyBatis
     * @param dataSource
     * @return
     */
    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DataSource dataSource){

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean;
    }


    @Bean
    ViewResolver viewResolver(@Autowired ServletContext servletContext){

        PebbleEngine engine = new PebbleEngine.Builder().autoEscaping(true)
                .cacheActive(false)
                .loader(new ServletLoader(servletContext))
                .extension(new SpringExtension())
                .build();
        PebbleViewResolver viewResolver=new PebbleViewResolver();
        viewResolver.setPrefix("/WEB-INF/templates");
        viewResolver.setSuffix("");
        viewResolver.setPebbleEngine(engine);
        return viewResolver;
    }

    public static void main(String[] args) throws Exception {
        //嵌入式启动Tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.getInteger("port",8080));//tomcat启动端口
        tomcat.getConnector();
        Context context = tomcat.addWebapp("", new File("Spring-SpringMVC/src/main/webapp").getAbsolutePath());
        WebResourceRoot resources=new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources,"/WEB-INF/classes",new File("Spring-SpringMVC/target/classes").getAbsolutePath(),"/"));
        context.setResources(resources);
        tomcat.start();
        tomcat.getServer().await();
    }
}
