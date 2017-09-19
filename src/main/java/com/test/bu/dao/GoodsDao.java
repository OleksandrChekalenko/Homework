package com.test.bu.dao;

import com.test.bu.entity.Goods;

import java.util.List;

/**
 * Created by Cagy on 9/18/2017.
 */
public interface GoodsDao {
    void save(Goods goods);

    Goods getGoodByPrice(double price);
    Goods getGoodById(int id);
    Goods getGoodByName(String name);
    Goods getGoodByMerchant(String merchant);

    Goods update(Goods newGood);

    List<Goods> getAllGoods();

    void deleteGoodById(int id);
    void  deleteGoodByName(String name);

}
