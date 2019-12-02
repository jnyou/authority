package cn.blithe.ssm.service;

import cn.blithe.ssm.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @ClassName UserService
 * @Deacription: 用户认证
 * @Author 夏小颜
 * @Date 2019/12/1 10:25
 * @Version 1.0
 **/
public interface UserService extends UserDetailsService {

    public List<UserInfo> queryAll();

    public void insert(UserInfo userInfo);

    public UserInfo queryById(String id);
}
