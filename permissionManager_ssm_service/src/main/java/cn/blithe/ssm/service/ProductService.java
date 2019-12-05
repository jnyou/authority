package cn.blithe.ssm.service;

import cn.blithe.ssm.pojo.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductService
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/23 14:39
 * @Version 1.0
 **/
public interface ProductService {

    /**
     * @Author: nankexiansheng
     * @Description: 
     * @Date: 2019/11/23
     * @Param: []
     * @Return: java.util.List<cn.blithe.ssm.pojo.Product>
     **/
    List<Product> queryProductList(int page,int size) throws Exception;

    /**
     * @Author: nankexiansheng
     * @Description: 保存产品信息
     * @Date: 2019/11/23
     * @Param: [product]
     * @Return: void
     **/
    void save(Product product) throws Exception;

    /**
     * @Author: nankexiansheng
     * @Description: 批量删除
     * @Date: 2019/11/25
     * @Param: [id]
     * @Return: int
     **/
    int batchDelete(Object[] id) throws Exception;

    /**
     * @Author: nankexiansheng
     * @Description: 查询单条数据
     * @Date: 2019/11/28
     * @Param: [id]
     * @Return: cn.blithe.ssm.pojo.Product
     **/
    Product queryProductById(String id);

    /**
     * @Author: nankexiansheng
     * @Description: 修改
     * @Date: 2019/11/28
     * @Param: [product]
     * @Return: java.lang.Integer
     **/
    Integer update(Product product);
}
