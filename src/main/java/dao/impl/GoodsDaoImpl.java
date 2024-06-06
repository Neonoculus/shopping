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

    /**
     * 通过类别和标签查询商品
     * @param cid
     * @param tid
     * @return
     */
    @Override
    public List<Goods> getGoodsByCIdAndTids(int cid, List<Integer> tid) {
        try {
            StringBuilder sql = new StringBuilder("select goods.g_id,goods.c_id,goods.m_id, goods.`name`,goods.photo,goods.price,goods.count,goods.`describe`,goods.`status`\n" +
                    "from goods\n" +
                    "join category on goods.c_id=category.c_id\n" +
                    "join merchant on goods.m_id=merchant.m_id\n" +
                    "join goods_tag on goods.g_id=goods_tag.g_id\n" +
                    "join tag on goods_tag.t_id=tag.t_id\n" +
                    "where goods.c_id = ?");
            if (!tid.isEmpty()) {
                for (int i = 0; i < tid.size(); i++) {
                    sql.append(" and goods.g_id in (select goods_tag.g_id from goods_tag join tag on goods_tag.t_id = tag.t_id where tag.t_id = ?)");
                }
            }
            sql.append(" group by goods.g_id;");
            Object[] params = tid.toArray(new Object[tid.size() + 1]);
            params[0] = cid;
            for (int i = 0; i < tid.size(); i++) {
                params[i+1] = tid.get(i);
            }
            List<Goods> goods = runner.query(sql.toString(), new BeanListHandler<>(Goods.class), params);
            return goods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过类别、标签和价格区间查询商品
     */
    @Override
    public List<Goods> getGoodsByCIdAndTidsAndPrice(int cid, List<Integer> tid, Double minPrice, Double maxPrice) {
        try {
            StringBuilder sql = new StringBuilder("select goods.g_id,goods.c_id,goods.m_id, goods.`name`,goods.photo,goods.price,goods.count,goods.`describe`,goods.`status`\n" +
                    "from goods\n" +
                    "join category on goods.c_id=category.c_id\n" +
                    "join merchant on goods.m_id=merchant.m_id\n" +
                    "join goods_tag on goods.g_id=goods_tag.g_id\n" +
                    "join tag on goods_tag.t_id=tag.t_id\n" +
                    "where goods.c_id = ?");
            if (!tid.isEmpty()) {
                for (int i = 0; i < tid.size(); i++) {
                    sql.append(" and goods.g_id in (select goods_tag.g_id from goods_tag join tag on goods_tag.t_id = tag.t_id where tag.t_id = ?)");
                }
            }
            sql.append(" and price >= ? AND price <= ? group by goods.g_id;");
            int size=tid.size();
            Object[] params = tid.toArray(new Object[size + 3]);
            params[0]=cid;
            for (int i = 0; i < size; i++) {
                params[i+1] = tid.get(i);
            }
            params[size+1]=minPrice;
            params[size+2]=maxPrice;
            List<Goods> goods = runner.query(sql.toString(), new BeanListHandler<>(Goods.class), params);
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

    /**
     *多条件查询商品
     */
    @Override
    public List<Goods> getGoodByAllQuery(String word) {
        try {
            List<Goods> goods = runner.query("SELECT goods.g_id,goods.c_id,goods.m_id, goods.`name`,goods.photo,goods.price,goods.count,goods.`describe`,goods.`status`\n" +
                    "FROM goods\n" +
                    "JOIN category on goods.c_id=category.c_id\n" +
                    "JOIN goods_tag on goods.g_id=goods_tag.g_id\n" +
                    "join merchant on goods.m_id=merchant.m_id\n" +
                    "join tag on goods_tag.t_id=tag.t_id\n" +
                    "WHERE category.`name` like ? OR\n" +
                    "\t\t\tgoods.`name` like ? OR\n" +
                    "\t\t\ttag.`name` like ? OR\n" +
                    "\t\t\tmerchant.`name` like ? \n" +
                    "GROUP BY goods.g_id;",new BeanListHandler<Goods>(Goods.class), "%" + word + "%","%" + word + "%","%" + word + "%","%" + word + "%");
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

    //  商品分页
    @Override
    public List<Goods>  findByPage(int start, int rows){
        try {
            List<Goods> goods = runner.query("select * from goods limit ? , ?", new BeanListHandler<Goods>(Goods.class),start,rows);
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
