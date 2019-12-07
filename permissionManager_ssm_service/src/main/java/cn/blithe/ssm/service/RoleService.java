package cn.blithe.ssm.service;

import cn.blithe.ssm.pojo.Role;

import java.util.List;

/**
 * @ClassName RoleService
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/2 14:41
 * @Version 1.0
 **/
public interface RoleService {
    public List<Role> queryRoleList(String userId);

    public List<Role> queryAll();

    public void save(Role role);

    public Role queryRoleByRoleId(String roleId);

    public List<Role> queryNotRoleList(String userId);

    public void saveBatchPermissionAndRole(String roleId,String [] permissionIds);
}
