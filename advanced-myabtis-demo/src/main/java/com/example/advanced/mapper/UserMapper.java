package com.example.advanced.mapper;
import com.example.advanced.model.SysUserAndPriviExtend;
import com.example.advanced.model.SysUserExtend;
import com.example.advanced.model.SysUserListExtend;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/8/4
 * @desc
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户id获取用户信息和用户的角色信息
     *
     *  一对一之；扩展实体类属性方式
     * @param id
     * @return
     */
    SysUserExtend selectUserAndRoleById(Long id);

    /**
     * 根据用户id获取用户信息和用户的角色信息  方式二:
     *
     * @param id
     * @return
     */
    SysUserExtend selectUserAndRoleByIdResultMap(Long id);

    /**
     * 根据用户id获取用户信息和用户的角色信息 方式三：
     * @param id
     * @return
     */
    SysUserExtend selectUserAndRoleByIdResultMapAssocation(Long id);


    /**
     * 根据用户id获取用户信息和用户的角色信息，嵌套查询方式
     *
     * @param id
     * @return
     */
    SysUserExtend selectUserAndRoleByIdSelect(Long id);


    /**
     *
     * 一对多示例
     * 获取所有的用户以及对应的所有角色
     * @return
     */
    List<SysUserListExtend> selectAllUserAndRoles();

    /**
     * 三层映射关系  use-->roles-->privili
     * @return
     */
    List<SysUserListExtend> selectAllUserAndRolesPrivi();
}
