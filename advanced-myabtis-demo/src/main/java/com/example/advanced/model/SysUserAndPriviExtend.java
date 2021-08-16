package com.example.advanced.model;

import java.util.List;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc
 * @see   {}现在的关联关系是：用户-->角色-->权限 三者相关
  */
public class SysUserAndPriviExtend extends SysUser{
    /**
     *  角色和权限集合
     */
    private List<SysRoleListExtend> sysRoleList;

    public List<SysRoleListExtend> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRoleListExtend> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    @Override
    public String toString() {
        return "SysUserAndPriviExtend{" +
                "sysRoleList=" + sysRoleList +
                "} " + super.toString();
    }
}
