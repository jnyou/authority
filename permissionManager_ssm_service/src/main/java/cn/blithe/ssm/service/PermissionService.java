package cn.blithe.ssm.service;

import cn.blithe.ssm.pojo.Permission;

import java.util.List;

/**
 * @ClassName PermissionService
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/2 15:58
 * @Version 1.0
 **/
public interface PermissionService {

    public List<Permission> queryPermissionByRoleId(String roleId);

    public List<Permission> queryAll();

    public void save(Permission permission);

    public Permission queryById(String pid);

    public void delete(String pid);

    public List<Permission> queryPermissionToUse(String roleId);
}
