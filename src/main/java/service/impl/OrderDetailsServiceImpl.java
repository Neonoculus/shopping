package service.impl;

import dao.OrderDetailsDao;
import dao.impl.OrderDetailsDaoImpl;
import domain.OrderDetails;
import service.OrderDetailsService;

import java.util.List;

public class OrderDetailsServiceImpl implements OrderDetailsService {
    OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();
    @Override
    public int add(OrderDetails orderDetails) {
        return orderDetailsDao.add(orderDetails);
    }

    @Override
    public int delete(int g_id, long o_id) {
        return orderDetailsDao.delete(g_id,o_id);
    }

    @Override
    public int update(OrderDetails orderDetails) {
        return orderDetailsDao.update(orderDetails);
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOId(long id) {
        return orderDetailsDao.getOrderDetailsByOId(id);
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsDao.getAllOrderDetails();
    }

    @Override
    public List<OrderDetails> findByPage(int start, int rows) {
        return orderDetailsDao.findByPage(start,rows);
    }


    @Override
    public List<OrderDetails> getOrderDetailsByMIdAndOId(int m_id, long o_id) {
        return orderDetailsDao.getOrderDetailsByMIdAndOId(m_id,o_id);
    }

}
