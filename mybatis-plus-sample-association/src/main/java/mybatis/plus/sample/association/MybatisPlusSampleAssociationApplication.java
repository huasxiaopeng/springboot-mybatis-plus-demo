package mybatis.plus.sample.association;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mybatis.plus.sample.association.mapper")
public class MybatisPlusSampleAssociationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusSampleAssociationApplication.class, args);
    }

}
