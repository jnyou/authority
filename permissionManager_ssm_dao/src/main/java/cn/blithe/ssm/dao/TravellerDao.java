package cn.blithe.ssm.dao;

import cn.blithe.ssm.pojo.Traveller;

import java.util.List;

/**
 * @ClassName TravellerDao
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/30 18:20
 * @Version 1.0
 **/
public interface TravellerDao {

    /**
     * @Author: nankexiansheng
     * @Description: 根据订单id查询订单详情的游客信息
     * @Date: 2019/11/30
     * @Param: [ordersId]
     * @Return: java.util.List<cn.blithe.ssm.pojo.Traveller>
     **/
    public List<Traveller> queryByOrderId(String ordersId) throws Exception;
}
