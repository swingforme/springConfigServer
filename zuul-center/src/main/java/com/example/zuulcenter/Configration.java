package com.example.zuulcenter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configration {


    @Value("${test.url:config server not found!}")
    private String bar;

//    @Bean
//    public AccessFilter accessFilter(){
//        System.out.println("=============>"+bar);
//        return new AccessFilter();
//    }

}
