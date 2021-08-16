package com.example.advanced.model;

import java.util.List;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc  角色扩展权限表
 *
 * 我们实现了需求：根据用户id查询用户信息的同时获取用户拥有的角色。
 * 因为角色可以拥有多个权限，所以本篇博客我们升级需求为：
 * 根据用户id查询用户信息的同时获取用户拥有的角色以及角色包含的权限。
 */
public class SysRoleListExtend  extends SysRole{
    /**
     * 角色包含的权限列表
     */
    private List<SysPrivilege> sysPrivilegeList;

    public List<SysPrivilege> getSysPrivilegeList() {
        return sysPrivilegeList;
    }

    public void setSysPrivilegeList(List<SysPrivilege> sysPrivilegeList) {
        this.sysPrivilegeList = sysPrivilegeList;
    }

    @Override
    public String toString() {
        return "SysRoleListExtend{" +
                "sysPrivilegeList=" + sysPrivilegeList +
                "} " + super.toString();
    }
}
