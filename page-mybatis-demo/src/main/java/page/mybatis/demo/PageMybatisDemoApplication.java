package page.mybatis.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("page.mybatis.demo.mapper")
public class PageMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PageMybatisDemoApplication.class, args);
    }

}
