package com.example.myabtis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.myabtis.mapper")
public class MyabtisPlueSampleResultmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyabtisPlueSampleResultmapApplication.class, args);
    }

}
