package cn.blithe.ssm.service.impl;

import cn.blithe.ssm.dao.OrdersDao;
import cn.blithe.ssm.pojo.Orders;
import cn.blithe.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName OrdersServiceImpl
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/23 22:50
 * @Version 1.0
 **/
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> queryOrdersList() {
        return ordersDao.queryOrdersList();
    }



}