package dao.impl;

import dao.GoodsTagDao;
import domain.GoodsTag;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class GoodsTagDaoImpl implements GoodsTagDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(GoodsTag goodsTag) {
        int result;
        try {
            result = runner.update("insert into goods_Tag(g_id,t_id) values(?,?)",
                    goodsTag.getG_id(),goodsTag.getT_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int g_id,int t_id) {
        int result;
        try {
            result = runner.update("delete from goods_Tag where g_id = ? and t_id = ?",g_id,t_id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GoodsTag> getGoodsTagByGId(int id) {
        try {
            List<GoodsTag> goodsTags = runner.query("select * from goods_Tag where g_id = ?", new BeanListHandler<GoodsTag>(GoodsTag.class), id);
            return goodsTags;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GoodsTag> getGoodsTagByTId(int id) {
        try {
            List<GoodsTag> goodsTags = runner.query("select * from goods_Tag where t_id = ?", new BeanListHandler<GoodsTag>(GoodsTag.class), id);
            return goodsTags;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GoodsTag> getAllGoodsTag() {
        try {
            List<GoodsTag> goodsTags = runner.query("select * from goods_Tag", new BeanListHandler<GoodsTag>(GoodsTag.class));
            return goodsTags;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
