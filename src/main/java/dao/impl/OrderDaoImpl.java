package dao.impl;

import dao.OrderDao;
import domain.Order;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(Order order) {
        int result;
        try {
            result = runner.update("insert into `order`(o_id,b_id,name,phone,address,money,start_Time,end_Time,status) values(?,?,?,?,?,?,?,?,?)",
                    order.getO_id(),order.getB_id(),order.getName(),order.getPhone(),order.getAddress(),order.getMoney(),order.getStartTime(),order.getEndTime(),order.getStatus());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        int result;
        try {
            result = runner.update("delete from `order` where o_id = ?",id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Order order) {
        int result;
        try {
            result = runner.update("update `order` set  b_id=?,name=?,phone=?,address=?,money=?,start_Time=?,end_Time=?,status=? where o_id=?",
                    order.getB_id(),order.getName(),order.getPhone(),order.getAddress(),order.getMoney(),order.getStartTime(),order.getEndTime(),order.getStatus(),order.getO_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order getOrderByOId(long id) {
        Order order = null;
        try {
            order = runner.query("select * from `order` where o_id = ? ",new BeanHandler<Order>(Order.class),id);
            return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getOrderByBId(int id) {
        try {
            List<Order> order = runner.query("select * from `order` where b_id = ?", new BeanListHandler<Order>(Order.class), id);
            return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getAllOrder() {
        try {
            List<Order> order = runner.query("select * from `order` ", new BeanListHandler<Order>(Order.class));
            return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
