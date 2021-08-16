package com.example;

import com.example.mapper.CountryMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class CommonMyabtisDemoApplication  implements CommandLineRunner {
    @Autowired
    private CountryMapper countryMapper;


    public static void main(String[] args) {
        SpringApplication.run(CommonMyabtisDemoApplication.class, args);
    }

    /**
     * 这是hello world demo
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        countryMapper.selectAll()
                .stream().forEach(System.out::println);
    }

}
