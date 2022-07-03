package com.example.zuulcenter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@RequestMapping("/test")
@EnableZuulProxy
@SpringBootApplication
public class ZuulCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulCenterApplication.class, args);

    }


    @Value("${test.url:config server not found!}")
    private String bar;

    @RequestMapping("/app")
    String hello() {
        return "Hello " + bar + "!";
    }

}
