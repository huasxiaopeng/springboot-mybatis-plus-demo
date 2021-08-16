package com.baomidou.mybatisplus.samples.quickstart;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    /**
     * 自己实现的插入
     */
    @Test
    public void lkInsert() {
        User user = new User();
        user.setName("小猫猫");
        user.setAge(10);
        user.setEmail("666@giam.com");
        assertThat(userMapper.insert(user)).isGreaterThan(0);
        assertThat(user.getId()).isNotNull();
    }

    /**
     * id 删除
     */
    @Test
    public void delete() {
        /**
         * 删除时，如果大于0 则表示删除成功
         */
        assertThat(userMapper.deleteById(3L)).isGreaterThan(0);
        /**
         * 根据条件进行删除
         *
         * 删除名字为sandy 的人物
         */
        assertThat(userMapper.delete(new QueryWrapper<User>()
                .lambda()
                .eq(User::getName, "Sandy"))).isGreaterThan(0);
    }

    /**
     * 几种更新方式
     */
    @Test
    public void update() {
        /**
         * 根据id 等于1 的进行设置值
         */
        assertThat(userMapper.updateById(new User().setId(1l)
                .setEmail("abc@an.com")
        )).isGreaterThan(0);
        /**
         * where 条件
         */
        assertThat(userMapper.update(new User().setName("mp"),
                Wrappers.<User>lambdaUpdate()
                        .set(User::getAge,3)
                         .eq(User::getId,2)
                )).isGreaterThan(0);
        /**
         *  判断更新结果
         */
        User user = userMapper.selectById(2);
        assertThat(user.getAge()).isEqualTo(3);
        assertThat(user.getName()).isEqualTo("mp");


        /**
         * 无参数: 直接根据条件进行更新想要的
         */
        userMapper.update(null,Wrappers.<User>lambdaUpdate()
        .set(User::getEmail,null).eq(User::getId,2));

        assertThat(userMapper.selectById(1).getEmail()).isEqualTo("abc@an.com");

        User user1 = userMapper.selectById(2);
        assertThat(user1.getName()).isEqualTo("mp");

        /**
         * 这个根据条件查询符合正常思维
         */
        userMapper.update(
                new User().setEmail("miemmie@gmail.com"),
                new QueryWrapper<User>().lambda().eq(User::getId,2)
        );
        User user2 = userMapper.selectById(2);
        assertThat(user2.getEmail()).isEqualTo("miemmie@gmail.com");

    }

    /**
     * 查询
     */
    @Test
    public void dSelect() {

//      userMapper.insert(new User()
//              .setId(10086l)
//              .setAge(3)
//              .setName("niuniu")
//              .setEmail("niuniu@gmail.com")
//      );
      assertThat(userMapper.selectById(10086).getEmail()).isEqualTo("niuniu@gmail.com");


        User user = userMapper.selectOne(new QueryWrapper<User>()
                .lambda()
                .eq(User::getId, 10086)
        );
        assertThat(user.getName()).isEqualTo("niuniu");

        userMapper.selectList(new QueryWrapper<User>().select("id","name"))
                .forEach(x->{
                    assertThat(x.getId()).isNotNull();
                    assertThat(x.getEmail()).isNull();
                    assertThat(x.getAge()).isNotNull();
                    assertThat(x.getName()).isNotNull();
                });

    }

    /**
     * 排序操作
     */
    @Test
    public void orderBy() {
        /**
         * 单条件排序
         */
        List<User> age = userMapper.selectList(Wrappers.<User>query().orderByAsc("age"));
        assertThat(age).isNotEmpty();
        /**
         * 多条件排序
         */
        List<User> users = userMapper.selectList(Wrappers.<User>query().orderByAsc(List.of("age", "name")));
        System.err.println("多条件排序的结果为："+users);


        /**
         * 不同条件，排序规则不同
         */
        List<User> users1 = userMapper.selectList(Wrappers.<User>query().orderByAsc("age").orderByDesc("name"));
        assertThat(users1).isNotEmpty();
    }

    /**
     * map 查询
     */
    @Test
    public void selectMaps() {
        List<Map<String, Object>> age =
                userMapper.selectMaps(Wrappers.<User>query().orderByAsc("age"));
        assertThat(age).isNotEmpty();
        assertThat(age.get(0)).isNotEmpty();
        System.out.println(age.get(0));
    }

    /**
     * 分页查询
     */
    @Test
    public void selectMapsPage() {
        Page<Map<String, Object>> page = userMapper.selectMapsPage(new Page<>(1, 2), Wrappers.<User>query().orderByAsc("age"));
        assertThat(page).isNotNull();
        assertThat(page.getRecords()).isNotEmpty();
        System.out.println(page.getRecords().get(0));
    }

    @Test
    public void testSelectMaxId() {
        /**
         * 构建查询条件
         */
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.select("max(id) as id");
        User user = userMapper.selectOne(wrapper);
        System.out.println("maxId"+user.getId());
        List<User> users = userMapper.selectList(Wrappers.<User>lambdaQuery().orderByDesc(User::getId));
        System.out.println(users);
    }

    /**
     * 分组
     */
    @Test
    public void testGroup() {
        QueryWrapper<User>wrapper=new QueryWrapper<>();
        wrapper.select("age, count(*)")
                .groupBy("age");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
        /**
         * lambdaQueryWrapper groupBy orderBy
         */
        LambdaQueryWrapper<User> lambdaQueryWrapper = new QueryWrapper<User>().lambda()
                .select(User::getAge)
                .groupBy(User::getAge)
                .orderByAsc(User::getAge);
        userMapper.selectList(lambdaQueryWrapper).forEach(System.err::println);




    }
}
