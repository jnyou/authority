package cn.blithe.ssm.controller;

import cn.blithe.ssm.pojo.Orders;
import cn.blithe.ssm.pojo.Product;
import cn.blithe.ssm.pojo.Traveller;
import cn.blithe.ssm.service.OrdersService;
import cn.blithe.ssm.service.TravellerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName OrdersController
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/23 22:52
 * @Version 1.0
 **/
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private TravellerService travellerService;

    @RequestMapping("/queryAll")
    public ModelAndView queryOrders(@RequestParam(name="page",required = true,defaultValue = "1") int page,@RequestParam(name="size",required = true,defaultValue = "4") int size) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Orders> orders = ordersService.queryOrdersList(page,size);
        // pageinfo就是一分页bean
        PageInfo pageInfo = new PageInfo(orders);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("orders-list");
        return mav;
    }

    /**
     * @Author: nankexiansheng
     * @Description: 订单详情信息，（产品信息、游客列表、会员信息）
     * @Date: 2019/11/30
     * @Param: []
     * @Return: org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
    public ModelAndView findById(@PathVariable("id") String id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Orders orders = ordersService.findById(id);
        List<Traveller> travellers = travellerService.queryByOrderId(id);
        orders.setTravellers(travellers);
        mav.addObject("orders",orders);
        mav.setViewName("orders-show");
        return mav;
    }

}