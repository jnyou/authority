package cn.blithe.ssm.service;

import cn.blithe.ssm.pojo.Traveller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName TravellerService
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/30 18:32
 * @Version 1.0
 **/
public interface TravellerService {
    /**
     * @Author: nankexiansheng
     * @Description: 订单详情游客信息列表
     * @Date: 2019/11/30
     * @Param: [ordersId]
     * @Return: java.util.List<cn.blithe.ssm.pojo.Traveller>
     **/
    List<Traveller> queryByOrderId(String ordersId) throws Exception;
}
