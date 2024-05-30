package dao.impl;

import dao.MerchantDao;
import domain.Merchant;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class MerchantDaoImpl implements MerchantDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(Merchant merchant) {
        int result;
        try {
            result = runner.update("insert into merchant(m_id,name,phone,address,email,photo,note) values(?,?,?,?,?,?,?)",
                    merchant.getM_id(),merchant.getName(),merchant.getPhone(),merchant.getAddress(),merchant.getEmail(),merchant.getPhoto(),merchant.getNote());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        int result;
        try {
            result = runner.update("delete from merchant where m_id = ?",id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Merchant merchant) {
        int result;
        try {
            result = runner.update("update merchant set name=?,phone=?,address=?,email=?,photo=?,note=? where m_id = ?",
                    merchant.getName(),merchant.getPhone(),merchant.getAddress(),merchant.getEmail(),merchant.getPhoto(),merchant.getNote(),merchant.getM_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Merchant getMerchantByMId(int id) {
        Merchant merchant = null;
        try {
            merchant = runner.query("select * from merchant where m_id = ? ",new BeanHandler<Merchant>(Merchant.class),id);
            return merchant;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Merchant> getMerchantByName(String name) {
        try {
            List<Merchant> merchants = runner.query("select * from merchant where name like ?", new BeanListHandler<Merchant>(Merchant.class), "%" + name + "%");
            return merchants;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Merchant getMerchantByPhone(String phone) {
        Merchant merchant = null;
        try {
            merchant = runner.query("select * from merchant where phone = ? ",new BeanHandler<Merchant>(Merchant.class),phone);
            return merchant;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Merchant getMerchantByEmail(String email) {
        Merchant merchant = null;
        try {
            merchant = runner.query("select * from merchant where email = ? ",new BeanHandler<Merchant>(Merchant.class),email);
            return merchant;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Merchant> getAllMerchant() {
        try {
            List<Merchant> merchant = runner.query("select * from merchant", new BeanListHandler<Merchant>(Merchant.class));
            return merchant;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
