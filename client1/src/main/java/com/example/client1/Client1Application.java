package com.example.client1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@RequestMapping("/test")
@SpringBootApplication
public class Client1Application {

	public static void main(String[] args) {
		SpringApplication.run(Client1Application.class, args);
	}

	@Value("${ab.bc.name:config server not found!}")
	private String bar;

	@RequestMapping("/app")
	String hello() {
		return "Hello " + bar + "!";
	}
}
