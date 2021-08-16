package com.example;

import com.example.mapper.RoleMapper;
import com.example.mapper.UserMapper;
import com.example.model.SysRole;
import com.example.model.SysUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class CommonMyabtisDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 单表 id 查询
     */
    @Test
    void test01() {
        SysUser sysUser = userMapper.selectById(1001L);
        Assert.assertEquals("test", sysUser.getUserName());
        System.out.println(sysUser);
    }

    /**
     * 查询全部
     */
    @Test
    void testSelectAll() {
        List<SysUser> sysUsers = userMapper.selectAll();
        sysUsers.stream().forEach(System.out::println);
    }

    /**
     * 根据用户id 查询用户角色信息
     */
    @Test
    public void testSelectRolesByUserId() {
        List<SysRole> sysRoles = userMapper.selectRolesByUserId(1l);
        Assert.assertTrue(sysRoles.size() > 0);
        sysRoles.stream().forEach(System.out::println);
    }

    /**
     * 两个参数调用
     */
    @Test
    public void testselectRolesByUserIdAndRoleEnabled() {
        List<SysRole> sysRoles = userMapper.selectRolesByUserIdAndRoleEnabled(1l, 1);
        sysRoles.stream().forEach(System.out::println);
    }

    /**
     * 通过对象传递参数
     */
    @Test
    public void testselectRolesByUserAndRole() {
        SysUser user = new SysUser();
        user.setId(1l);
        SysRole role = new SysRole();
        role.setEnabled(1);
        List<SysRole> sysRoles = userMapper.selectRolesByUserAndRole(user, role);
        sysRoles.stream().forEach(System.out::println);
    }

    /**
     * add
     */
    @Test
    public void testInsert() {
        SysUser sysUser = new SysUser();
        sysUser.setUserName("test1");
        sysUser.setUserPassword("123456");
        sysUser.setUserEmail("test@mybatis.tk");
        sysUser.setUserInfo("test info");
        // 正常情况下应该读入一张图片保存到byte数组中
        sysUser.setHeadImg(new byte[]{1, 2, 3});
        sysUser.setCreateTime(new Date());
        int insert = userMapper.insert(sysUser);
        if (insert > 0) {
            System.out.println("add 成功");
        } else {
            System.out.println("插入失败");
        }
    }

    /**
     * add 获取返回的id
     * <p>
     * 回写主键的方法只适用于支持主键自增的数据库。
     * <p>
     * 但有些数据库（比如Oracle）不提供主键自增的功能，
     * 而是使用序列得到一个值，然后将这个值赋给id，再将数据插入到数据库。
     */
    @Test
    public void insertUseGeneratedKeys() {
        SysUser sysUser = new SysUser();
        sysUser.setUserName("77777");
        sysUser.setUserPassword("77777");
        sysUser.setUserEmail("7777@mybatis.tk");
        sysUser.setUserInfo("77777info");
        // 正常情况下应该读入一张图片保存到byte数组中
        sysUser.setHeadImg(new byte[]{1, 2, 3});
        sysUser.setCreateTime(new Date());
        int insert = userMapper.insertUseGeneratedKeys(sysUser);
        if (insert > 0) {
            System.out.println("add 成功");
            System.out.println("返回的userId 为：" + sysUser.getId());
        } else {
            System.out.println("插入失败");
        }
    }

    /**
     * 删除操作
     */
    @Test
    public void testUpdateById() {
        SysUser sysUser = userMapper.selectById(1005l);
        if(Objects.nonNull(sysUser)){
            sysUser.setUserName("admin_test");
            sysUser.setUserEmail("admin_test@mybatis.tk");
            sysUser.setUserInfo("test info");
            // 正常情况下应该读入一张图片保存到byte数组中
            sysUser.setHeadImg(new byte[]{1, 2, 3});
            sysUser.setCreateTime(new Date());
            int i = userMapper.updateById(sysUser);
            if(i>0){
                System.out.println("更新成功");
                SysUser user = userMapper.selectById(1005l);
                System.out.println(user);
            }
        }
    }

    /**
     *  根据给定id 或者对象id 进行删除
     */
    @Test
    public void testDeleteById() {

        int i = userMapper.deleteById(1005l);
        Assert.assertEquals(1,i);

        SysUser user = userMapper.selectById(1004l);
        int i1 = userMapper.deleteBySysUser(user);
        assertEquals(1,i1);
    }

    /**
     *  注解方式查询
     */
    @Test
    public void testAnnocationById() {
        SysRole role = roleMapper.selectById(1l);
        System.out.println("查询的数据为："+role);

    }

    /**
     * 注解插入
     */
    @Test
    public void testAnnocationInsert() {
        SysRole role=new SysRole();
        role.setRoleName("guligu");
        role.setCreateTime(new Date());
        role.setCreateBy(2l);
        role.setEnabled(0);

        int i = roleMapper.insertUseGeneratedKeys(role);
        if(i>0&&role.getId()!=null){
            System.out.println("返回的数据主键为："+role.getId());
        }
    }

    /**
     * 注解更新
     */
    @Test
    public void testAnnocationUpdate() {
        SysRole role=new SysRole();
        role.setRoleName("up-date");
        role.setCreateTime(new Date());
        role.setCreateBy(1l);
        role.setEnabled(1);
        role.setId(3l);
        int i = roleMapper.updateById(role);
        if(i>0&&role.getId()!=null){
            System.out.println("返回的数据主键为："+role.getId());
        }
    }

    /**
     * 注解删除
     */
    @Test
    public void testAnnocationDelete() {

        int i = roleMapper.deleteById(3l);
        if(i>0){
            System.out.println("删除成功。。。");
        }
    }

    /**
     * 根据条件查询
     */
    @Test
    public void testSelectByUser() {
        // 只按用户名查询
        SysUser query = new SysUser();
        query.setUserName("ad");
        List<SysUser> sysUsers = userMapper.selectByUser(query);

        System.out.println("只按用户名查询："+sysUsers);

        // 只按邮箱查询
        query = new SysUser();
        query.setUserEmail("test@mybatis.tk");
        sysUsers = userMapper.selectByUser(query);
        System.out.println("根据邮箱查询的条件为："+sysUsers);


        // 同时按用户和邮箱查询
        query = new SysUser();
        query.setUserName("ad");
        query.setUserEmail("test@mybatis.tk");
        sysUsers = userMapper.selectByUser(query);
        System.out.println("同时按用户民和邮箱查询"+sysUsers);
    }

    /**
     * 非空字段不进行更新
     */
    @Test
    public void testUpdateByIdSelective() {
        SysUser sysUser = new SysUser();
        // 更新id=1的用户
        sysUser.setId(1L);
        // 修改邮箱
        sysUser.setUserEmail("test@mybatis.tk");

        int i = userMapper.updateByIdSelective(sysUser);
        System.out.println(i);

    }

    @Test
    public void testInsertSelective() {

        SysUser sysUser = new SysUser();
        sysUser.setUserName("test-selective");
        sysUser.setUserPassword("123456");
        sysUser.setUserInfo("test info");
        sysUser.setCreateTime(new Date());
        int i = userMapper.insertSelective(sysUser);
        if(i>0){
            System.out.println("插入成功。。。");
        }
    }
    @Test
    public void testSelectByUserWhere() {

        // 只按用户名查询
        SysUser query = new SysUser();
        query.setUserName("ad");
        List<SysUser> sysUsers = userMapper.selectByUserWhere(query);
        System.out.println(sysUsers);
        // 只按邮箱查询
        query = new SysUser();
        query.setUserEmail("test@mybatis.tk");
        sysUsers = userMapper.selectByUserWhere(query);
        System.out.println(sysUsers);

        // 同时按用户民和邮箱查询
        query = new SysUser();
        query.setUserName("ad");
        query.setUserEmail("test@mybatis.tk");
        sysUsers = userMapper.selectByUserWhere(query);
        System.out.println(sysUsers);

    }
    @Test
    public void testUpdateByIdSelectiveSet() {
        SysUser sysUser = new SysUser();
        // 更新id=1的用户
        sysUser.setId(1001L);
        // 修改邮箱
        sysUser.setUserEmail("11001@mybatis.tk");
        int i = userMapper.updateByIdSelectiveSet(sysUser);
    }
    @Test
    public void testSelectByIdList() {
        List<Long> idList = new ArrayList<Long>();
        idList.add(1L);
        idList.add(1001L);
        List<SysUser> sysUsers = userMapper.selectByIdList(idList);
        System.out.println(sysUsers);
    }
    @Test
    public void testInsertList() {
        List<SysUser> sysUserList = new ArrayList<SysUser>();
        for (int i = 0; i < 2; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test" + i);
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@mybatis.tk");

            sysUserList.add(sysUser);
        }
        int result =  userMapper.insertList(sysUserList);
        for (SysUser sysUser : sysUserList) {
            System.out.println(sysUser.getId());
        }
    }

    @Test
    public void testUpdateByMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1008L);
        map.put("user_email", "test@mybatis.tk");
        map.put("user_password", "12345678");
        Assert.assertEquals(1, userMapper.updateByMap(map));
        SysUser sysUser = userMapper.selectById(1008L);
        System.out.println(sysUser);

    }
}


