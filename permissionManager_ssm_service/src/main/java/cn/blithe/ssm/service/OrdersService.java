package cn.blithe.ssm.service;

import cn.blithe.ssm.pojo.Orders;

import java.util.List;

/**
 * @ClassName Orders
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/23 22:48
 * @Version 1.0
 **/
public interface OrdersService {
    List<Orders> queryOrdersList(int page,int size) throws Exception;

    /**
     * @Author: nankexiansheng
     * @Description: 订单详情
     * @Date: 2019/11/30
     * @Param: [id]
     * @Return: cn.blithe.ssm.pojo.Orders
     **/
    Orders findById(String id);
}
