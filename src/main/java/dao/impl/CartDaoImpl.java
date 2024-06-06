package dao.impl;

import dao.CartDao;
import domain.Cart;
import domain.dto.CartDto;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class CartDaoImpl implements CartDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(Cart cart) {
        int result;
        try {
            result = runner.update("insert into cart(g_id,b_id,count,money,status) values(?,?,?,?,?)",
                    cart.getG_id(),cart.getB_id(),cart.getCount(),cart.getMoney(),cart.getStatus());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(Cart cart) {
        int result;
        try {
            result = runner.update("delete from cart where b_id = ? and g_id = ?",cart.getB_id(),cart.getG_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Cart cart) {
        int result;
        try {
            result = runner.update("update cart set count=?, money=?, status=? where b_id=? and g_id = ?",
                    cart.getCount(),cart.getMoney(),cart.getStatus(),cart.getB_id(),cart.getG_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cart> getCartByBId(int id) {
        try {
            List<Cart> carts = runner.query("select * from cart where b_id = ?", new BeanListHandler<Cart>(Cart.class),id);
            return carts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cart> getAllCart() {
        try {
            List<Cart> carts = runner.query("select * from cart", new BeanListHandler<Cart>(Cart.class));
            return carts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CartDto> getCartDtoById(int id) {
        try {
            List<CartDto> cartDtos = runner.query("select cart.g_id,cart.b_id,goods.name,goods.photo,cart.count,cart.money,goods.status from cart,goods where b_id = ? and cart.g_id=goods.g_id", new BeanListHandler<CartDto>(CartDto.class),id);
            return cartDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
