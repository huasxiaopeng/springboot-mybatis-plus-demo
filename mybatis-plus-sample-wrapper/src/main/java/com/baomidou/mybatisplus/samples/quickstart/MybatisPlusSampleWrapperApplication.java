package com.baomidou.mybatisplus.samples.quickstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class MybatisPlusSampleWrapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusSampleWrapperApplication.class, args);
    }

}
