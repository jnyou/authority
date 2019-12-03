package cn.blithe.ssm.dao;

import cn.blithe.ssm.pojo.Permission;

import java.util.List;

/**
 * @ClassName PermissionDao
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/2
 * @Version 1.0
 **/
public interface PermissionDao {
    /**
     * @Author: nankexiansheng
     * @Description: 根据角色id查询出权限信息
     * @Date: 2019/12/2
     * @Param: [roleId]
     * @Return: java.util.List<cn.blithe.ssm.pojo.Permission>
     **/
    public List<Permission> queryPermissionByRoleId(String roleId);

    public List<Permission> queryAll();

    public void save(Permission permission);

    public Permission queryById(String pid);

    public void delete(String pid);
}
