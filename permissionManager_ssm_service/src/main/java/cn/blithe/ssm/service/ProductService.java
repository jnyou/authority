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
    List<Product> queryProductList() throws Exception;

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
}
