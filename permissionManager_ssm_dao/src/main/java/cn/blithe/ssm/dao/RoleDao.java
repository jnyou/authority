package cn.blithe.ssm.dao;

import cn.blithe.ssm.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName RoleDao
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/1 11:57
 * @Version 1.0
 **/
public interface RoleDao {
    /**
     * @Author: nankexiansheng
     * @Description: 通过中间表根据用户id查询角色信息
     * @Date: 2019/12/1
     * @Param: [userId]
     * @Return: java.util.List<cn.blithe.ssm.pojo.Role>
     **/
    public List<Role> queryRoleList(String userId);

    public List<Role> queryAll();

    public void save(Role role);

    public Role queryRoleByRoleId(String roleId);

    /**
     * @Author: nankexiansheng
     * @Description: 根据用户id查询当前用户可以添加的角色
     * @Date: 2019/12/7
     * @Param: [userId]
     * @Return: java.util.List<cn.blithe.ssm.pojo.Role>
     **/
    public List<Role> queryNotRoleList(String userId);

    /**
     * @Author: nankexiansheng
     * @Description: 批量保存角色id和权限id至中间表
     * @Date: 2019/12/7
     * @Param: [roleId, permissionId]
     * @Return: void
     **/
    public void saveBatchPermissionAndRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
