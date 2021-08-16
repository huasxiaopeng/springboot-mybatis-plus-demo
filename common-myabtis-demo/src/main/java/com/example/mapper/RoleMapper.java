package com.example.mapper;

import com.example.model.SysRole;
import org.apache.ibatis.annotations.*;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc  注解实现
 */
@Mapper
public interface RoleMapper {
    /**
     * @ResultMap 映射对照关系
     */
    @ResultMap("roleMap")
    @Select("SELECT id,role_name,enabled,create_by,create_time FROM sys_role WHERE id = #{id}")
    SysRole selectById(Long id);

    /**
     * 新建，并返回主键自增
     */
    @Insert("INSERT INTO sys_role(role_name, enabled, create_by, create_time)VALUES (#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertUseGeneratedKeys(SysRole sysRole);

    @Update({"UPDATE sys_role ", "SET role_name = #{roleName},enabled = #{enabled},create_by=#{createBy}, ",
            "create_time=#{createTime,jdbcType=TIMESTAMP} ", " WHERE id=#{id}"})
    int updateById(SysRole sysRole);

    @Delete("DELETE FROM sys_role WHERE id = #{id}")
    int deleteById(Long id);
}
