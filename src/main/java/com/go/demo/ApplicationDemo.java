package com.go.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootConfiguration
@SpringBootApplication
@MapperScan("com.go.demo.dao")
public class ApplicationDemo {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationDemo.class, args);
    }
}
