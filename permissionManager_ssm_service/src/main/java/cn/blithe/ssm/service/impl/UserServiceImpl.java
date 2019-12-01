package cn.blithe.ssm.service.impl;

import cn.blithe.ssm.dao.RoleDao;
import cn.blithe.ssm.dao.UserDao;
import cn.blithe.ssm.pojo.Role;
import cn.blithe.ssm.pojo.UserInfo;
import cn.blithe.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/1 10:26
 * @Version 1.0
 **/
@Service("userService")  //使用spring-security定义的UserDetails的实现类
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.queryByUserName(username);
            List<Role> roles = roleDao.queryRoleList(userInfo.getId());
            userInfo.setRoles(roles);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 处理自己的用户对象封装成UserDetails返回，通过UserDetails接口的一个User实现类来处理
        //User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        // 状态0 未开启 1 开启  判断状态是否可用 未开启也是不能登陆成功的
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));

        return user;

    }

    // 获取用户的角色信息
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}