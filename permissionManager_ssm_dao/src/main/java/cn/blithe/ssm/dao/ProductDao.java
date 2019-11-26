package cn.blithe.ssm.dao;

import cn.blithe.ssm.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductDao
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/23 14:35
 * @Version 1.0
 **/
public interface ProductDao {

    /**
     * @Author: nankexiansheng
     * @Description: 查询所有产品信息
     * @Date: 2019/11/23
     * @Param: []
     * @Return: java.util.List<cn.blithe.ssm.pojo.Product>
     **/
    @Select("select * from product")
    List<Product> queryProductList() throws Exception;

    /**
     * @Author: nankexiansheng
     * @Description: 保存产品信息
     * @Date: 2019/11/23
     * @Param: [product]
     * @Return: void
     **/
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    /**
     * @Author: nankexiansheng
     * @Description: 批量删除
     * @Date: 2019/11/25
     * @Param: [id]
     * @Return: int
     **/
    int batchDelete(Object[] id);
}
