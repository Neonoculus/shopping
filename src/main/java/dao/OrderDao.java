package dao;

import domain.Order;

import java.util.List;

public interface OrderDao {
    int add(Order order);
    int delete(int id);
    int update(Order order);
    Order getOrderByOId(long id);
    List<Order> getOrderByBId(int id);
    List<Order> getAllOrder();
}
