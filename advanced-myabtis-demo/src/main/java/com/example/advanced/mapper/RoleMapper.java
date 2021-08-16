package com.example.advanced.mapper;


import com.example.advanced.model.SysRole;
import com.example.advanced.model.SysRoleListExtend;
import org.apache.ibatis.annotations.*;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc
 */
@Mapper
public interface RoleMapper {
/**
 * 仍然延用上篇博客中的需求：根据用户id查询用户信息的同时获取该用户的角色信息(
 * 假设一个员工只能拥有一个角色)。
 * 在上篇博客中，我们分别使用了3种方式来实现这个需求，但这3个需求都有一个共同点，
 * 就是我们使用了多表查询，即查询一次数据库就获取到我们想要的所有数据。
 * 有的同学就说了，我不喜欢多表查询的方式，数据量大的时候会影响性能，
 * 这么简单的需求，我可以拆分成两步啊，第一步，先根据用户id查询出用户的信息和用户的角色id（
 * 仍然要关联表，只是由3张表关联减为了2张表关联），第二步，根据第一步查询出的角色id再去查询角色信息。
 * 这种方式当然可以，而且使用业务代码就能实现这个逻辑，
 * 不过本篇博客我们不讲这种方式，而是通过association标签来实现。
 */
    /**
     * 根据id 查询角色信息
      * @param id
     * @return
     */
   SysRole selectRoleById(@Param("id") Long id);
}
