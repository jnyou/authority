package cn.blithe.ssm.controller;

import cn.blithe.ssm.pojo.Product;
import cn.blithe.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addObject("productList", products);
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
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:queryAll";
    }

    /**
     * @Author: nankexiansheng
     * @Description: 删除和批量删除
     * @Date: 2019/11/26
     * @Param: [idStrs]
     * @Return: java.util.Map<java.lang.String, java.lang.Object>
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

    /**
     * @Author: nankexiansheng
     * @Description: 开启
     * @Date: 2019/11/28
     * @Param: [statusid]
     * @Return: java.lang.String
     **/
    @RequestMapping("/open")
    @ResponseBody
    public String open(String statusID) throws Exception {
        String[] str = statusID.split(",");
        try {
            for (int i = 0; i < str.length; i++) {
                Product pro = productService.queryProductById(str[i]);
                pro.setProductStatus(1);
                productService.update(pro);
            }
        } catch (Exception e) {
            return "error";
        }
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/close")
    public String close(String statusID) throws Exception {
        String[] arr = statusID.split(",");
        try {
            for (int i = 0; i < arr.length; i++) {
                Product pro = productService.queryProductById(arr[i]);
                pro.setProductStatus(0);
                productService.update(pro);
            }
        } catch (Exception e) {
            return "error";
        }
        return "ok";
    }

    @RequestMapping("/edit")
    public String edit(String id,Model model) {
        if(!id.isEmpty()){
            Product pro = productService.queryProductById(id);
            model.addAttribute("productList",pro);
            return "product-add";
        }else{
            return "redirect:queryAll";
        }
    }

    @RequestMapping("/edit")
    public String update(Product product) {
        Integer effectNum = productService.update(product);
        return "redirect:queryAll";
    }
}