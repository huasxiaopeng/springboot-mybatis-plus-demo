package com.example.advanced.model;

import java.util.List;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc 一对多实例
 * @see {}需求：根据用户id查询用户信息的同时获取用户拥有的角色，一个用户可以拥有1个或多个角色。
 */
public class SysUserListExtend extends SysUser{
    /**
     * 用户的角色集合
     */
    private List<SysRole> sysRoleList;
    private List<SysRoleListExtend> roleListExtends;

    public List<SysRoleListExtend> getRoleListExtends() {
        return roleListExtends;
    }

    public void setRoleListExtends(List<SysRoleListExtend> roleListExtends) {
        this.roleListExtends = roleListExtends;
    }

    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    @Override
    public String toString() {
        return "SysUserListExtend{" +
                "sysRoleList=" + sysRoleList +
                ", roleListExtends=" + roleListExtends +
                "} " + super.toString();
    }
}
