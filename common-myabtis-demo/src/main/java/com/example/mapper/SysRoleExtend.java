package com.example.mapper;

import com.example.model.SysRole;
import com.example.model.SysUser;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc 扩展sysrole 实体类的属性，方便返回
 */
public class SysRoleExtend extends SysRole {
    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}