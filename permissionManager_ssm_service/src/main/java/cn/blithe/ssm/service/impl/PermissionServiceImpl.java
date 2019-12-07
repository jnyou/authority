package cn.blithe.ssm.service.impl;

import cn.blithe.ssm.dao.PermissionDao;
import cn.blithe.ssm.pojo.Permission;
import cn.blithe.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName PermissionServiceImpl
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/2 15:59
 * @Version 1.0
 **/
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> queryPermissionByRoleId(String roleId) {
        return permissionDao.queryPermissionByRoleId(roleId);
    }

    @Override
    public List<Permission> queryAll() {
        return permissionDao.queryAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public Permission queryById(String pid) {
        return permissionDao.queryById(pid);
    }

    @Override
    public void delete(String pid) {
        permissionDao.delete(pid);
    }

    @Override
    public List<Permission> queryPermissionToUse(String roleId) {
        return permissionDao.queryPermissionToUse(roleId);
    }
}