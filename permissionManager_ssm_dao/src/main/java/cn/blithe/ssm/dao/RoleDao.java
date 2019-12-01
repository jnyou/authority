package cn.blithe.ssm.dao;

import cn.blithe.ssm.pojo.Role;

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
}
