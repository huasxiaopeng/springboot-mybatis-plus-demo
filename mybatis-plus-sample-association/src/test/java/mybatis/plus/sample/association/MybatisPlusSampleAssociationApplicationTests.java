package mybatis.plus.sample.association;

import mybatis.plus.sample.association.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class MybatisPlusSampleAssociationApplicationTests {

    @Autowired
    IUserService userService;
    @Test
    public void testSelectList() {

        userService.list().forEach(t -> System.out.println(t.getCompany()));
    }


}
