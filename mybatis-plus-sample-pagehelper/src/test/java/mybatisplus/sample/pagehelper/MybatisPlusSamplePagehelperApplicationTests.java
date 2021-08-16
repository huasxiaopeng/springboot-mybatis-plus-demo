package mybatisplus.sample.pagehelper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisPlusSamplePagehelperApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CountryMapper mapper;

    /**
     * 指定id 分页查询
     */
    @Test
    void testPage() {
//        Mp分页插件使用
        Page<User> mpPage =userMapper.selectPage(new Page<>(1,2), Wrappers.<User>query().eq("id",1));
        System.out.println(mpPage.getTotal());

        // pagehelper 分页插件使用
        PageInfo<User> info = PageHelper.startPage(1, 2)
                .doSelectPageInfo(() -> userMapper.selectById(1));
        info.getList().stream().forEach(System.out::println);
    }
    /**
     *  mybatis-plus范围id 查询
     */
    @Test
    void testMpPages() {
        List <Integer>ids=new ArrayList<Integer>();
        for (int i = 0; i <100 ; i++) {
            ids.add(i);
        }
       // Page<Country> mpPages = mapper.selectPage(new Page<>(1, 5), Wrappers.<Country>query().in("id", ids));
        Page<Country> mpPages = mapper.selectPage(new Page<>(2, 10), Wrappers.<Country>query().in("id", ids));
        mpPages.getRecords().forEach(System.out::println);
    }

    /**
     *  mybatis范围id 查询
     */
    @Test
    void testMyBatisPages() {
        List <Integer>ids=new ArrayList<Integer>();
        for (int i = 0; i <100 ; i++) {
            ids.add(i);
        }
//        PageInfo<Country> info = PageHelper.startPage(1, 10).doSelectPageInfo(
//                () -> mapper.selectList(Wrappers.<Country>query().in("id", ids)));
        PageInfo<Country> info = PageHelper.startPage(3, 10).doSelectPageInfo(
                () -> mapper.selectList(Wrappers.<Country>query().in("id", ids)));
        long total = info.getTotal();
        System.out.println(total);
        info.getList().forEach(System.out::println);
    }
}
