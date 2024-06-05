package service.impl;

import domain.OrderDetails;
import service.OrderDetailsDao;

import java.util.List;

public class OrderDetailsDaoImpl implements OrderDetailsDao {
    OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();
    @Override
    public int add(OrderDetails orderDetails) {
        return orderDetailsDao.add(orderDetails);
    }

    @Override
    public int delete(int g_id, int o_id) {
        return orderDetailsDao.delete(g_id,o_id);
    }

    @Override
    public int update(OrderDetails orderDetails) {
        return orderDetailsDao.update(orderDetails);
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOId(int id) {
        return orderDetailsDao.getOrderDetailsByOId(id);
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsDao.getAllOrderDetails();
    }
}
