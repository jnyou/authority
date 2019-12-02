package cn.blithe.ssm.service.impl;

import cn.blithe.ssm.dao.RoleDao;
import cn.blithe.ssm.pojo.Role;
import cn.blithe.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/2 14:42
 * @Version 1.0
 **/
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> queryRoleList(String userId) {
        return roleDao.queryRoleList(userId);
    }
}