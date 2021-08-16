package com.baomidou.mybatisplus.samples.quickstart;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.RoleMapper;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 条件查询demo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;

    @Test
    public void testSelect() {
        System.out.println("------普通查询-------");
        List<User> role_id = userMapper.selectList(new QueryWrapper<User>().eq("role_id", 2L));
        List<User> users = userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getId, 2L));
//        Assert.assertEquals(role_id.size(),users.size());
        print(role_id);

        System.out.println("----- 带子查询(sql注入) ------");

        List<User> role_id1 = userMapper.selectList(new QueryWrapper<User>()
                .inSql("role_id", "select id from role where id =2"));
        System.out.println(role_id1);
        List<User> users1 = userMapper.selectList(new QueryWrapper<User>().lambda().inSql(User::getRoleId, "select id from role where id =2"));
        System.out.println(users1);

        System.out.println("----- 带嵌套查询 ------");
        /**
         * 等价于 条件 where role_id =2 or role_id =1 and age >20
         */
        List<User> users2 = userMapper.selectList(new QueryWrapper<User>().nested(i -> i.eq("role_id", 2l).or().eq("role_id", 3l))
                .and(i -> i.ge("age", 20)));
        List<User> users3 = userMapper.selectList(new QueryWrapper<User>().lambda()
                .nested(i -> i.eq(User::getRoleId, 2L).or().eq(User::getRoleId, 3l))
                .and(i -> i.ge(User::getAge, 20)));
        System.out.println("嵌套查询的值为："+users2);
        System.out.println("lambda嵌套查询的值为："+users3);




    }
    /**
     * SELECT id,name,age,email,role_id FROM user
     * WHERE ( 1 = 1 ) AND ( ( name = ? AND age = ? ) OR ( name = ? AND age = ? ) )
     */
    @Test
    public void testSql() {
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.and(i->i.eq("1",1))
                .nested(i->i.and(j->j.eq("name","a").eq("age",2))
                .or(j->j.eq("name","b").eq("age",2)));
        userMapper.selectList(queryWrapper).forEach(System.err::println);
    }
    /**
     * SELECT id,name FROM user
     * WHERE (age BETWEEN ? AND ?) ORDER BY role_id ASC,id ASC
     */
    @Test
    public void testBetweenDemo() {
        QueryWrapper<User>queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id","name").between("age",20,25)
                .orderByAsc("role_id","id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

        LambdaQueryWrapper<User>lwq=new LambdaQueryWrapper<>();
        lwq.select(User::getId,User::getName).between(User::getAge,20,25)
                .orderByAsc(User::getRoleId,User::getId);
        userMapper.selectList(lwq).forEach(System.out::println);

    }
    /**
     * UPDATE user SET age=?, email=? WHERE (name = ?)
     */
    @Test
    public void tests() {
        /**
         * 方式一：
         */
        User user=new User();
        user.setAge(29);
        user.setEmail("test@gaim.com");
        userMapper.update(user,new UpdateWrapper<User>().eq("name","Tom"));

        /**
         * 方式二：不创建user对象
         */

        userMapper.update(null,new UpdateWrapper<User>()
        .set("age",30).set("email","jiji@gmail.com").eq("name","Jack"));
    }
    /**
     * 使用lambda条件构造器
     * UPDATE user SET age=?, email=? WHERE (name = ?)
     */
    @Test
    public void testLambda() {
        User user = new User();
        user.setAge(29);
        user.setEmail("test3update@baomidou.com");
        userMapper.update(user,new LambdaUpdateWrapper<User>().eq(User::getName,"Tom"));

        userMapper.update(null,new LambdaUpdateWrapper<User>().set(User::getAge,29).set(User::getEmail,"jackUpdate@baomidou.com").eq(User::getName,"Jack"));
    }
    private <T> void print(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(System.out::println);
        }
    }

}
