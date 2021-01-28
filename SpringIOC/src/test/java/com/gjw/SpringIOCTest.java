package com.gjw;


import com.gjw.config.AppConfig;
import com.gjw.service.AppService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SpringIOCTest {

    @Autowired
    private AppService appService;

    @Test
    public void test(){
        System.out.println(appService.getLogo());
        try {
            appService.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(appService.getLogo());

    }
}
