package cn.blithe.ssm.controller;

import cn.blithe.ssm.pojo.Orders;
import cn.blithe.ssm.pojo.Product;
import cn.blithe.ssm.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}