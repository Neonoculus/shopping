package dao.impl;

import dao.GoodsDao;
import domain.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(Goods goods) {
        int result;
        try {
            result = runner.update("insert into goods(g_id,c_id,m_id,name,photo,price,`describe`,`status`,count) values(?,?,?,?,?,?,?,?,?)",
                    goods.getG_id(),goods.getC_id(),goods.getM_id(),goods.getName(),goods.getPhoto(),goods.getPrice(),goods.getDescribe(),goods.getStatus(),goods.getCount());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        int result;
        try {
            result = runner.update("delete from goods where g_id = ?",id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Goods goods) {
        int result;
        try {
            result = runner.update("update goods set  c_id=?, m_id=?, name=?,photo=?, price=?, `describe`=?, `status`=?,count=? where g_id=?",
                    goods.getC_id(),goods.getM_id(),goods.getName(),goods.getPhoto(),goods.getPrice(),goods.getDescribe(),goods.getStatus(),goods.getCount(),goods.getG_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Goods getGoodsByGId(int id) {
        Goods goods = null;
        try {
            goods = runner.query("select * from goods where g_id = ? ",new BeanHandler<Goods>(Goods.class),id);
            return goods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> getGoodsByCId(int id) {
        try {
            List<Goods> goods = runner.query("select * from goods where c_id = ?", new BeanListHandler<Goods>(Goods.class), id);
            return goods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> getGoodsByMId(int id) {
        try {
            List<Goods> goods = runner.query("select * from goods where m_id = ?", new BeanListHandler<Goods>(Goods.class), id);
            return goods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> getGoodsByName(String name) {
        try {
            List<Goods> goods = runner.query("select * from goods where name like ?", new BeanListHandler<Goods>(Goods.class), "%" + name + "%");
            return goods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> getGoodsByPrice(Double minPrice, Double maxPrice) {
        try {
            List<Goods> goods = runner.query("select * from goods where price >? and price < ?", new BeanListHandler<Goods>(Goods.class),minPrice,maxPrice);
            return goods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> getGoodsByStatus(int status) {
        try {
            List<Goods> goods = runner.query("select * from goods where status = ?", new BeanListHandler<Goods>(Goods.class), status);
            return goods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Goods> getAllGoods() {
        try {
            List<Goods> goods = runner.query("select * from goods", new BeanListHandler<Goods>(Goods.class));
            return goods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
