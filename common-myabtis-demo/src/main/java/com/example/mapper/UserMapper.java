package com.example.mapper;

import com.example.model.SysRole;
import com.example.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc  常规xml 操作
 */
@Mapper
public interface UserMapper {
    /**
     *  根据id 查询
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查询全部
     * @return
     */
    List<SysUser>selectAll();
    /**
     * 根据用户id获取角色信息
     *   涉及到了三个表，分别是用户表：角色表，用户角色关联表
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 根据用户id和角色的enabled状态获取用户的角色
     *   两个参数 ，没必要创建一个对象
     * @param userId
     * @param enabled
     * @return
     */
    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);

    /**
     *  传递的参数为对象
     * @param user
     * @param role
     * @return
     */
    List<SysRole>selectRolesByUserAndRole(@Param("user")SysUser user,@Param("role")SysRole role);

    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);


    /**
     * add 操作返回新增的数据库id
     */
    int insertUseGeneratedKeys(SysUser sysUser);


    /**
     * 根据主键更新
     *
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);


    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据对象的主键删除
     *
     * @param sysUser
     * @return
     */
    int deleteBySysUser(SysUser sysUser);


    /**
     *  根据条件动态查询用户信息
     */
    List<SysUser> selectByUser(SysUser sysUser);


    /**
     * 根据主键选择性更新用户信息
     *
     * @param sysUser
     * @return
     */
    int updateByIdSelective(SysUser sysUser);

    /**
     * 根据传入的参数值动态插入列
     *
     * @param sysUser
     * @return
     */
    int insertSelective(SysUser sysUser);

    /**
     * 根据动态条件查询用户信息(使用Where标签)
     *
     * @param sysUser
     * @return
     */
    List<SysUser> selectByUserWhere(SysUser sysUser);

    /**
     * 根据主键选择性更新用户信息(使用Set标签)
     *假设有这样1个需求：更新用户信息的时候不能将原来有值但没有发生变化的字段更新为空或null，即只更新有值的字段。
     * @param sysUser
     * @return
     */
    int updateByIdSelectiveSet(SysUser sysUser);
    /**
     * 根据用户id集合查询用户
     *
     * @param idList
     * @return
     */
    List<SysUser> selectByIdList(List<Long> idList);

    /**
     * 批量插入用户信息
     *
     * @param userList
     * @return
     */
    int insertList(List<SysUser> userList);

    /**
     * 通过Map更新列
     *假设有这样1个需求：根据传入的Map参数更新用户信息。
     * @param map
     * @return
     */
    int updateByMap(@Param("userMap") Map<String, Object> map);

}
