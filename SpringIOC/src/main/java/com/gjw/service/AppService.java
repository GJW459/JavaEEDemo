package com.gjw.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class AppService {

    @Value("C:\\Users\\gjw\\Desktop\\JavaEEDemo\\SpringIOC\\src\\test\\resources\\logo.txt")
    private Resource resource;
    @Value("gjw")
    private String logo;

    public void init() throws IOException {
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))){
            this.logo=reader.readLine();
        }
    }

    public String getLogo() {
        return logo;
    }
}
