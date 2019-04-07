package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.jpoint.starter")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{DemoApplication.class}, args);

    }

}
