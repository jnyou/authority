package cn.blithe.ssm.dao;

import cn.blithe.ssm.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * @Author: nankexiansheng
     * @Description:
     * @Date: 2019/12/2
     * @Param: []
     * @Return: java.util.List<cn.blithe.ssm.pojo.UserInfo>
     **/
    public List<UserInfo> queryAll();

    /**
     * @Author: nankexiansheng
     * @Description: 新增
     * @Date: 2019/12/2
     * @Param: [userInfo]
     * @Return: void
     **/
    public void insert(UserInfo userInfo);

    /**
     * @Author: nankexiansheng
     * @Description: 查询用户详情信息
     * @Date: 2019/12/2
     * @Param: [id]
     * @Return: cn.blithe.ssm.pojo.UserInfo
     **/
    public UserInfo queryById(String id);

    public void saveRoles(@Param("userId") String userId,@Param("roleId") String roleId);
}
