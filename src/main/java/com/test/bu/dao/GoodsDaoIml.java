package com.test.bu.dao;

import com.test.bu.config.SpringConfig;
import com.test.bu.entity.Goods;
import com.test.bu.mappers.GoodsMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Cagy on 9/18/2017.
 */
public class GoodsDaoIml implements GoodsDao {
    private JdbcTemplate jdbcTemplate;
    private ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private GoodsDao goodsDao = context.getBean(GoodsDaoIml.class);
    public GoodsDaoIml(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Goods goods) {
        boolean exist = true;
        int count = 0;
        if (exist) {
            List<Goods> allGoods = goodsDao.getAllGoods();
            for (Goods good : allGoods) {
                if (good.getName().equals(goods.getName()) && good.getPrice() == goods.getPrice() ) {
                    update(goods);
                    count++;
                }
            }
            if (count == 0)
                exist = false;

        } else {
        String sql = " INSERT INTO goods(name, price, merchant) VALUES(?,?,?)";
        jdbcTemplate.update(sql, goods.getName(), goods.getPrice(), goods.getMerchant());
    }}

    @Override
    public Goods getGoodByPrice(double price) {
        String sql = "SELECT FROM goods WHERE price = ?";
        return jdbcTemplate.queryForObject(sql, new GoodsMapper(),price);
    }

    @Override
    public Goods getGoodById(int id) {
        String sql = "SELECT FROM goods WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql, new GoodsMapper(), id);
    }

    @Override
    public Goods getGoodByName(String name) {
        String sql = "SELECT FROM goods WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new GoodsMapper(), name);
    }

    @Override
    public Goods getGoodByMerchant(String merchant) {
        String sql = "SELECT FROM goods WHERE merchant = ?";
        return jdbcTemplate.queryForObject(sql, new GoodsMapper(), merchant);
    }


    @Override
    public Goods update(Goods newGood) {
        String sql = "UPDATE goods SET name = ?, price = ?, merchant = ?";
        int update = jdbcTemplate.update(sql, newGood.getName(), newGood.getPrice(), newGood.getMerchant());
        if (update > 0 )
            System.out.println("Successful update.");
        return null;
    }

    @Override
    public List<Goods> getAllGoods() {
        String sql = "SELECT * FROM goods";
        return jdbcTemplate.query(sql, new GoodsMapper());
    }

    @Override
    public void deleteGoodById(int id) {
        String sql = "DELETE FROM goods WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void deleteGoodByName(String name) {
        String sql = "DELETE FROM goods WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

}
