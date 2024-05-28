package dao;

import domain.OrderDetails;

public interface OrderDetailsDao {
    void add(OrderDetails orderDetails);
    void delete(int id);
    void update(OrderDetails orderDetails,int id);
    OrderDetails[] oIdSelect(int id);
    OrderDetails[] Select();
}
