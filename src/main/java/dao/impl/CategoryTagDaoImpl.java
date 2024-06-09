package dao.impl;

import dao.CategoryTagDao;
import domain.CategoryTag;
import domain.GoodsTag;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class CategoryTagDaoImpl implements CategoryTagDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(CategoryTag categoryTag) {
        int result;
        try {
            result = runner.update("insert into category_tag(c_id,t_id) values(?,?)",
                    categoryTag.getC_id(),categoryTag.getT_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int c_id, int t_id) {
        int result;
        try {
            result = runner.update("delete from category_tag where c_id = ? and t_id = ?",c_id,t_id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CategoryTag> getCategoryTagByCid(int id) {
        try {
            List<CategoryTag> categoryTags = runner.query("select * from category_tag where c_id = ?", new BeanListHandler<CategoryTag>(CategoryTag.class), id);
            return categoryTags;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CategoryTag> getAllCategoryTag() {
        try {
            List<CategoryTag> categoryTags = runner.query("select * from category_tag", new BeanListHandler<CategoryTag>(CategoryTag.class));
            return categoryTags;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
