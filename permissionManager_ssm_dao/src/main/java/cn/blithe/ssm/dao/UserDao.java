package cn.blithe.ssm.dao;

import cn.blithe.ssm.pojo.UserInfo;

/**
 * @ClassName UserDao
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/12/1 10:36
 * @Version 1.0
 **/
public interface UserDao {

    /**
     * @Author: nankexiansheng
     * @Description: 登陆认证
     * @Date: 2019/12/1
     * @Param: [username]
     * @Return: cn.blithe.ssm.pojo.UserInfo
     **/
    public UserInfo queryByUserName(String username) throws Exception;
}
