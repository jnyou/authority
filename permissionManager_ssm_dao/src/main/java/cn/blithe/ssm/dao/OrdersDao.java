package cn.blithe.ssm.dao;

import cn.blithe.ssm.pojo.Orders;
import cn.blithe.ssm.pojo.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName OrdersDao
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/23 22:34
 * @Version 1.0
 **/
public interface OrdersDao {
//    @Select("select o.*,p.productname,p.productprice from orders o,product p where o.productid=p.id")
//    @Results({
//            @Result(id=true,property = "id",column = "id"),
//            @Result(property = "orderNum",column = "orderNum"),
//            @Result(property = "orderTime",column = "orderTime"),
//            @Result(property = "orderStatus",column = "orderStatus"),
//            @Result(property = "peopleCount",column = "peopleCount"),
//            @Result(property = "peopleCount",column = "peopleCount"),
//            @Result(property = "payType",column = "payType"),
//            @Result(property = "orderDesc",column = "orderDesc"),
//            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
//    })
    /**
     * @Author: nankexiansheng
     * @Description: 订单列表
     * @Date: 2019/11/30
     * @Param: []
     * @Return: java.util.List<cn.blithe.ssm.pojo.Orders>
     **/
    public List<Orders> queryOrdersList();

    /**
     * @Author: nankexiansheng
     * @Description: 订单详情
     * @Date: 2019/11/30
     * @Param: [id]
     * @Return: cn.blithe.ssm.pojo.Orders
     **/
    public Orders findById(String id);
}
