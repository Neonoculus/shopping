package dao.impl;

import dao.TagDao;
import domain.Tag;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class TagDaoImpl implements TagDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(Tag tag) {
        int result;
        try {
            result = runner.update("insert into tag(t_id,name) values(?,?)",
                    tag.getT_id(),tag.getName());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        int result;
        try {
            result = runner.update("delete from tag where t_id = ?",id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Tag tag) {
        int result;
        try {
            result = runner.update("update tag set  name=? where t_id=?",
                    tag.getName(),tag.getT_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Tag getTagByTId(int id) {
        Tag tag = null;
        try {
            tag = runner.query("select * from tag where t_id = ? ",new BeanHandler<Tag>(Tag.class),id);
            return tag;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tag> getTagByName(String name) {
        try {
            List<Tag> tags = runner.query("select * from tag where name like ?", new BeanListHandler<Tag>(Tag.class), "%" + name + "%");
            return tags;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tag> getAllTag() {
        try {
            List<Tag> tags = runner.query("select * from tag", new BeanListHandler<Tag>(Tag.class));
            return tags;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tag> getTagByCId(int cid) {
        try {
          List<Tag> tags = runner.query("SELECT tag.t_id,tag.`name`\n" +
                  "FROM category_tag\n" +
                  "JOIN tag on category_tag.t_id = tag.t_id\n" +
                  "WHERE c_id = ? \n",new BeanListHandler<>(Tag.class),cid);
            return tags;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
