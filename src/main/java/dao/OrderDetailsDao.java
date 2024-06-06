package dao;

import domain.OrderDetails;

import java.util.List;

public interface OrderDetailsDao {
    int add(OrderDetails orderDetails);
    int delete(int g_id, int o_id);
    int update(OrderDetails orderDetails);
    List<OrderDetails> getOrderDetailsByOId(long id);
    List<OrderDetails> findByPage(int start, int rows);
    List<OrderDetails> getOrderDetailsByMIdAndOId(int m_id,int o_id);
    List<OrderDetails> getAllOrderDetails();
}
