package cn.blithe.ssm.service.impl;

import cn.blithe.ssm.dao.ProductDao;
import cn.blithe.ssm.pojo.Product;
import cn.blithe.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Product
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/23 14:45
 * @Version 1.0
 **/
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> queryProductList() throws Exception {
        return productDao.queryProductList();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public int batchDelete(Object[] id) throws Exception {
        return productDao.batchDelete(id);
    }


}