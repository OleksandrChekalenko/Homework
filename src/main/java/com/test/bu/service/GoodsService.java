package com.test.bu.service;

import com.test.bu.entity.Goods;

/**
 * Created by Cagy on 9/18/2017.
 */
public interface GoodsService {
    Goods getGoodByPrice(double price);

    Goods getGoodById(int id);

    Goods getGoodByName(String name);
    Goods getGoodByMerchant(String merchant);
}
