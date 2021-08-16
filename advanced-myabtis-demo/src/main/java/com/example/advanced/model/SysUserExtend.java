package com.example.advanced.model;

import java.util.List;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc  给用户实体扩展 角色信息
 */
public class SysUserExtend extends SysUser {
    /**
     * 用户角色
     */
    private SysRole sysRole;
    public SysRole getSysRole() {
        return sysRole;
    }
    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }


    @Override
    public String toString() {
        return "SysUserExtend{" +
                "sysRole=" + sysRole +
                "} " + super.toString();
    }
}
