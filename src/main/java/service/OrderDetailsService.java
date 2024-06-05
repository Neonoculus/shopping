package service;

import domain.OrderDetails;

import java.util.List;

public interface OrderDetailsService {
    int add(OrderDetails orderDetails);
    int delete(int g_id, int o_id);
    int update(OrderDetails orderDetails);
    List<OrderDetails> getOrderDetailsByOId(int id);
    List<OrderDetails> getAllOrderDetails();
}
