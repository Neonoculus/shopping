package dao.impl;

import dao.CategoryDao;
import domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(Category category) {
        int result;
        try {
            result = runner.update("insert into category(c_id,name) values(?,?)",
                    category.getC_id(),category.getName());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        int result;
        try {
            result = runner.update("delete from category where c_id = ?",id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Category category) {
        int result;
        try {
            result = runner.update("update category set name=? where c_id = ?",
                    category.getName(),category.getC_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category getCategoryByCId(int id) {
        Category category = null;
        try {
            category = runner.query("select * from category where c_id = ? ",new BeanHandler<Category>(Category.class),id);
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> getCategoryByName(String name) {
        List<Category> category = null;
        try {
            category = runner.query("select * from category where name like ? ",new BeanListHandler<Category>(Category.class),name);
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> getAllCategory() {
        try {
            List<Category> categories = runner.query("select * from category", new BeanListHandler<Category>(Category.class));
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
