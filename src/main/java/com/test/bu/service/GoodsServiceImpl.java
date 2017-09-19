package com.test.bu.service;

import com.test.bu.dao.GoodsDao;
import com.test.bu.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Cagy on 9/18/2017.
 */
@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsDao goodsDao;


    @Override
    public Goods getGoodByPrice(double price) {
        if (price == 0) {
            System.out.println("Price is 0.");
            return null;
        } else
        return goodsDao.getGoodByPrice(price);
    }

    @Override
    public Goods getGoodById(int id) {
        return goodsDao.getGoodById(id);
    }

    @Override
    public Goods getGoodByName(String name) {
        if (name.length() > 20) {
            System.out.println("Name length more than 20 characters.");
            return null;
        }
        return goodsDao.getGoodByName(name);
    }

    @Override
    public Goods getGoodByMerchant(String merchant) {
        if (merchant.length() > 20) {
            System.out.println("Merchant length more than 20 characters.");
        }
        return null;
    }
}
