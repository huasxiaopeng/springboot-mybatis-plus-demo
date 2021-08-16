package com.example.myabtis;

import com.example.myabtis.entity.Child;
import com.example.myabtis.entity.Man;
import com.example.myabtis.entity.Woman;
import com.example.myabtis.mapper.ChildMapper;
import com.example.myabtis.mapper.ManMapper;
import com.example.myabtis.mapper.WomanMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
class MyabtisPlueSampleResultmapApplicationTests {
    @Resource
    private ChildMapper childMapper;
    @Resource
    private ManMapper manMapper;
    @Resource
    private WomanMapper womanMapper;

    @Test
    void contextLoads() {
        System.out.printf("啦啦啦");
    }

    @Test
    void t_c() {
        Child child = childMapper.selectLinkById(1l);
        log.info("child:{}",child);
        assertThat(child).isNotNull();
        Man laoHan = child.getLaoHan();
        assertThat(laoHan.getName()).isNotBlank();
        Woman laoMa = child.getLaoMa();
        assertThat(laoMa).isNotNull();
        assertThat(laoMa.getName()).isNotBlank();
    }

}
