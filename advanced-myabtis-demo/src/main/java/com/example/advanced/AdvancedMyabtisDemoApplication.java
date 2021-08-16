package com.example.advanced;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.advanced.mapper")
public class AdvancedMyabtisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedMyabtisDemoApplication.class, args);
    }

}
