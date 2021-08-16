package com.example.advanced;

import com.example.advanced.mapper.UserMapper;
import com.example.advanced.model.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class AdvancedMyabtisDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    /**
     * 表之间关联关系 一对一：
     */
    @Test
    public void testSelectUserAndRoleById() {
        SysUserExtend sysUserExtend = userMapper.selectUserAndRoleById(1001l);
        System.out.println(sysUserExtend.toString());
    }

    /**
     * 配置方式二：
     */
    @Test
    public void testSelectUserAndRoleByIdTwo() {
        SysUserExtend sysUserExtend = userMapper.selectUserAndRoleByIdResultMap(1001l);
        System.err.println("获取的用户信息是:" + sysUserExtend.toString());
    }

    /**
     * 配置方式三：
     */
    @Test
    public void testSelectUserAndRoleByIdThree() {
        SysUserExtend sysUserExtend = userMapper.selectUserAndRoleByIdResultMapAssocation(1001L);
        System.err.println("获取的用户信息是:" + sysUserExtend.toString());
    }

    /**
     * 嵌套查询
     */
    @Test
    public void testSelectUserAndRoleByIdSelect() {
        SysUserExtend sysUserExtend = userMapper.selectUserAndRoleByIdSelect(1001l);
        System.err.println("获取的用户信息是:" + sysUserExtend.toString());

        System.out.println("调用sysUserExtend.equals(null)");
        sysUserExtend.equals(null);

        System.out.println("调用sysUserExtend.getSysRole()");
        Assert.assertNotNull(sysUserExtend.getSysRole());
    }
    /**
     * 一对多测试
     */
    @Test
    public void testSelectAllUserAndRoles() {
        List<SysUserListExtend> sysUserList = userMapper.selectAllUserAndRoles();
        System.out.println("用户数：" + sysUserList.size());
        for (SysUserListExtend sysUser : sysUserList) {
            System.out.println("用户名：" + sysUser.getUserName());
            for (SysRole sysRole : sysUser.getSysRoleList()) {
                System.out.println("角色名：" + sysRole.getRoleName());
            }
        }
    }

    /**
     * 用户id 查询角色信息，在根据角色id 查询角色所对应的权限id
     */
    @Test
    public void selectAllUserAndRolesPrivi() {

        List<SysUserListExtend> sysUserList= userMapper.selectAllUserAndRolesPrivi();
        System.out.println("用户数：" + sysUserList.size());
        for (SysUserListExtend sysUser : sysUserList) {
            System.out.println("用户名：" + sysUser.getUserName());
            for (SysRoleListExtend roleListExtend : sysUser.getRoleListExtends()) {
                System.out.println("角色名："+roleListExtend.getRoleName());
                for (SysPrivilege sysPrivilege : roleListExtend.getSysPrivilegeList()) {
                    System.out.println("权限名为："+sysPrivilege);
                }
            }
        }
    }
}