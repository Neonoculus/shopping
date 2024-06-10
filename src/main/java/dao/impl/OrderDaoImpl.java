package dao.impl;

import dao.OrderDao;
import domain.Order;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    QueryRunner runner =  new QueryRunner(DBUtil.getDataSource());

    private static ResultSetHandler<List<Order>> getListResultSetHandler() {
        return rs -> {
            List<Order> result = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order();
                order.setO_id(rs.getLong("o_id"));
                order.setB_id(rs.getInt("b_id"));
                order.setMoney(rs.getDouble("money"));
                order.setName(rs.getString("name"));
                order.setPhone(rs.getString("phone"));
                order.setAddress(rs.getString("address"));
                order.setStatus(rs.getInt("status"));

                // 手动将数据库的 Timestamp 转换为 LocalDateTime 类型
                Timestamp startTimestamp = rs.getTimestamp("start_time");
                if (startTimestamp != null) {
                    order.setStartTime(startTimestamp.toLocalDateTime());
                }

                Timestamp endTimestamp = rs.getTimestamp("end_time");
                if (endTimestamp != null) {
                    order.setEndTime(endTimestamp.toLocalDateTime());
                }

                result.add(order);
            }
            return result;
        };
    }
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
    public List<Order> getOrderByOId(long id) {
        try {
            List<Order> orders = runner.query("select * from `order` where o_id = ? ",getListResultSetHandler(),id);
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getOrderByBId(int id) {
        try {
            List<Order> orders = runner.query("select * from `order` where b_id = ? order by `order`.o_id desc",getListResultSetHandler(), id);
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过商家id获取订单
     * @param id
     * @return
     */
    @Override
    public List<Order> getOrderByMId(int id) {
        try {
            List<Order> orders = runner.query("SELECT `order`.o_id,`order`.b_id,`order`.money,`order`.start_time,`order`.end_time,`order`.name,`order`.phone,\n" +
                    "`order`.address,`order`.`status`\n" +
                    "FROM `order`\n" +
                    "JOIN order_details on order_details.o_id = `order`.o_id\n" +
                    "JOIN goods on goods.g_id = order_details.g_id\n" +
                    "WHERE goods.m_id = ?", getListResultSetHandler(), id);

            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findByPageAndMId(int id,int start, int rows) {
        try {
            List<Order> orders = runner.query("SELECT `order`.o_id,`order`.b_id,`order`.money,`order`.start_time,`order`.end_time,`order`.name,`order`.phone,\n" +
                    "`order`.address,`order`.`status`\n" +
                    "FROM `order`\n" +
                    "JOIN order_details on order_details.o_id = `order`.o_id\n" +
                    "JOIN goods on goods.g_id = order_details.g_id\n" +
                    "WHERE goods.m_id = ? limit ? , ?", getListResultSetHandler(),id,start,rows);
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getAllOrder() {
        try {
            List<Order> order = runner.query("select * from `order` ", getListResultSetHandler());
            return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
