package service.impl;

import domain.OrderDetails;
import service.OrderDetailsService;

import java.util.List;

public class OrderDetailsServiceImpl implements OrderDetailsService {
    OrderDetailsService orderDetailsService = new OrderDetailsServiceImpl();
    @Override
    public int add(OrderDetails orderDetails) {
        return orderDetailsService.add(orderDetails);
    }

    @Override
    public int delete(int g_id, int o_id) {
        return orderDetailsService.delete(g_id,o_id);
    }

    @Override
    public int update(OrderDetails orderDetails) {
        return orderDetailsService.update(orderDetails);
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOId(long id) {
        return orderDetailsService.getOrderDetailsByOId(id);
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsService.getAllOrderDetails();
    }

    @Override
    public List<OrderDetails> findByPage(int start, int rows) {
        return orderDetailsService.findByPage(start,rows);
    }


    @Override
    public List<OrderDetails> getOrderDetailsByMIdAndOId(int m_id, int o_id) {
        return orderDetailsService.getOrderDetailsByMIdAndOId(m_id,o_id);
    }

}
