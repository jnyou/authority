package cn.blithe.ssm.controller;

import cn.blithe.ssm.pojo.Product;
import cn.blithe.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductController
 * @Deacription 产品信息控制器
 * @Author 夏小颜
 * @Date 2019/11/23 15:07
 * @Version 1.0
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * @Author: nankexiansheng
     * @Description: 
     * @Date: 2019/11/23
     * @Param: []
     * @Return: org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping(value = "/queryAll")
    public ModelAndView queryAllProduct() throws Exception {
        ModelAndView model = new ModelAndView();
        List<Product> products = productService.queryProductList();
        model.addObject("productList",products);
        model.setViewName("product-list");
        return model;
    }

    /**
     * @Author: nankexiansheng
     * @Description: 保存产品信息
     * @Date: 2019/11/23
     * @Param: [product]
     * @Return: void
     **/
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:queryAll";
    }

    /**
     * @Author: nankexiansheng
     * @Description: 删除和批量删除
     * @Date: 2019/11/26
     * @Param: [idStrs]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("/delete")
    @ResponseBody
    public String bacthDelete(String idStrs) throws Exception {
        String[] str = idStrs.split(",");
        try {
            //批量删除
            productService.batchDelete(str);//删除的方法
        } catch (Exception e) {
            return "error";
        }
        return "ok";
    }

}