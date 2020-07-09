package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan("com.example.demo.mapper")
public class DemoCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCodeApplication.class, args);
    }

}
