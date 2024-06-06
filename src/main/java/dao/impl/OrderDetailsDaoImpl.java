package dao.impl;

import dao.OrderDetailsDao;
import domain.OrderDetails;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailsDaoImpl implements OrderDetailsDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());
    @Override
    public int add(OrderDetails orderDetails) {
        int result;
        try {
            result = runner.update("insert into order_Details(o_id,g_id,count,money) values(?,?,?,?)",
                    orderDetails.getO_id(),orderDetails.getG_id(),orderDetails.getCount(),orderDetails.getMoney());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int g_id, int o_id) {
        int result;
        try {
            result = runner.update("delete from order_Details where g_id = ? and o_id = ?",g_id,o_id);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(OrderDetails orderDetails) {
        int result;
        try {
            result = runner.update("update order_Details set  G_id=?, Count=?, Money=? where O_id=?",
                    orderDetails.getG_id(),orderDetails.getCount(),orderDetails.getMoney(),orderDetails.getO_id());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOId(int id) {
        try {
            List<OrderDetails> orderDetails = runner.query("select * from order_Details where o_id = ?", new BeanListHandler<OrderDetails>(OrderDetails.class), id);
            return orderDetails;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        try {
            List<OrderDetails> orderDetails = runner.query("select * from order_Details", new BeanListHandler<OrderDetails>(OrderDetails.class));
            return orderDetails;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderDetails> getOrderDetailsByMIdAndOId(int m_id, int o_id) {
        try {
            String sql = "SELECT order_details.g_id, order_details.o_id, order_details.count, order_details.money " +
                    "FROM order_details " +
                    "JOIN `order` ON `order`.o_id = order_details.o_id " +
                    "JOIN goods ON goods.g_id = order_details.g_id " +
                    "WHERE goods.m_id = ? AND `order_details`.o_id = ?";
            List<OrderDetails> orderDetails = runner.query(sql,new BeanListHandler<OrderDetails>(OrderDetails.class),m_id,o_id);
            return orderDetails;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
