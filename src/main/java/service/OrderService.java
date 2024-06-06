package service;

import domain.Order;

import java.util.List;

public interface OrderService {
    int add(Order order);
    int delete(int id);
    int update(Order order);
    Order getOrderByOId(long id);
    List<Order> getOrderByBId(int id);
    List<Order> getOrderByMId(int id);
    List<Order>  findByPage(int start, int rows);
    List<Order> getAllOrder();

}