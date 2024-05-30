package dao.impl;

import dao.LikeDao;
import domain.Like;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class LikeDaoImpl implements LikeDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(Like like) {
        int result;
        try {
            result = runner.update("insert into `like`(g_id,b_id) values(?,?)",
                    like.getG_id(),like.getB_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        int result;
        try {
            result = runner.update("delete from `like` where g_id = ?",id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Like> getLikeByBId(int id) {
        try {
            List<Like> likes = runner.query("select * from `like` where b_id = ?", new BeanListHandler<Like>(Like.class), id);
            return likes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Like> getAllLike() {
        try {
            List<Like> goods = runner.query("select * from `like`", new BeanListHandler<Like>(Like.class));
            return goods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
