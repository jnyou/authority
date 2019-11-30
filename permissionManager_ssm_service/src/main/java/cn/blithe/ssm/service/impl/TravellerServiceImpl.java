package cn.blithe.ssm.service.impl;

import cn.blithe.ssm.dao.TravellerDao;
import cn.blithe.ssm.pojo.Traveller;
import cn.blithe.ssm.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName TravellerServiceImpl
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/30 18:33
 * @Version 1.0
 **/
@Service
@Transactional
public class TravellerServiceImpl implements TravellerService {

    @Autowired
    private TravellerDao travellerDao;

    @Override
    public List<Traveller> queryByOrderId(String ordersId) throws Exception {
        return travellerDao.queryByOrderId(ordersId);
    }
}