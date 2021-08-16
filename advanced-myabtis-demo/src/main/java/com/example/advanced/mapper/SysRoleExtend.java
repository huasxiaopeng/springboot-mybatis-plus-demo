package com.example.advanced.mapper;


import com.example.advanced.model.SysRole;
import com.example.advanced.model.SysUser;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc  一对一映射之 扩展实体类实现
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