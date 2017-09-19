package com.test.bu.mappers;

import com.test.bu.entity.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Cagy on 9/18/2017.
 */
public class GoodsMapper implements org.springframework.jdbc.core.RowMapper<Goods> {

    @Override
    public Goods mapRow(ResultSet resultSet, int i) throws SQLException {
        Goods good = new Goods();
        good.setId(resultSet.getInt("id"));
        good.setName(resultSet.getString("name"));
        good.setPrice(resultSet.getDouble("price"));
        good.setMerchant(resultSet.getString("merchant"));
        return  good;
    }
}
