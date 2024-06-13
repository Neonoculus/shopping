package dao.impl;

import dao.BuyerDao;
import domain.Buyer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class BuyerDaoImpl implements BuyerDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(Buyer buyer) {
        int result;
        try {
            result = runner.update("insert into buyer(b_id,name,email,address,phone,photo) values(?,?,?,?,?,?)",
                    buyer.getB_id(),buyer.getName(),buyer.getEmail(),buyer.getAddress(),buyer.getPhone(),buyer.getPhoto());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        int result;
        try {
            result = runner.update("delete from buyer where b_id = ?",id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Buyer buyer) {
        int result;
        try {
            result = runner.update("update buyer set name=?, email=?, address=?, phone=?,photo=? where b_id=?",
                    buyer.getName(),buyer.getEmail(),buyer.getAddress(),buyer.getPhone(),buyer.getPhoto(),buyer.getB_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Buyer getBuyerByBId(int id) {
        Buyer buyer = null;
        try {
            buyer = runner.query("select * from buyer where b_id = ? ",new BeanHandler<Buyer>(Buyer.class),id);
            return buyer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Buyer> getBuyerByName(String name) {
        try {
            List<Buyer> buyers = runner.query("select * from buyer where name like ?", new BeanListHandler<Buyer>(Buyer.class), "%" + name + "%");
            return buyers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Buyer getBuyerByEmail(String email) {
        Buyer buyer = null;
        try {
            buyer = runner.query("select * from Buyer where email = ? ",new BeanHandler<Buyer>(Buyer.class),email);
            return buyer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Buyer getBuyerByPhone(String phone) {
        Buyer buyer = null;
        try {
            buyer = runner.query("select * from Buyer where phone = ? ",new BeanHandler<Buyer>(Buyer.class),phone);
            return buyer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Buyer> findByPage(int start, int rows) {
        try {
            List<Buyer> buyers = runner.query("select * from Buyer limit ? ,?", new BeanListHandler<Buyer>(Buyer.class),start,rows);
            return buyers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Buyer> getAllBuyer() {
        try {
            List<Buyer> buyers = runner.query("select * from Buyer", new BeanListHandler<Buyer>(Buyer.class));
            return buyers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
