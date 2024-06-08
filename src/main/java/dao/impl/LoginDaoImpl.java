package dao.impl;

import dao.LoginDao;
import domain.Login;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class LoginDaoImpl implements LoginDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(Login login) {
        int result;
        try {
            result = runner.update("insert into login(l_id,username,password,type,id) values(?,?,?,?,?)",
                    login.getL_id(),login.getUsername(),login.getPassword(),login.getType(),login.getId());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        int result;
        try {
            result = runner.update("delete from login where l_id = ?",id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Login login) {
        int result;
        try {
            result = runner.update("update login set  username=?, password=?,type=?, id=? where l_id=?",
                    login.getUsername(),login.getPassword(),login.getType(),login.getId(),login.getL_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Login getLoginById(int id) {
        Login login = null;
        try {
            login = runner.query("select * from login where id = ? ",new BeanHandler<Login>(Login.class),id);
            return login;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Login Login(String username, String password) {
        try {
            Login login = runner.query("select * from login where username = ? and password = ?",new BeanHandler<Login>(Login.class),username,password);
            return login;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Login> getAllLogin() {
        try {
            List<Login> logins = runner.query("select * from login", new BeanListHandler<Login>(Login.class));
            return logins;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
