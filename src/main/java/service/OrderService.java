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
    int[] OrderAmountNumber(List<Order> orders);
    Double[] OrderMoneyNumber(List<Order> orders);
    List<Order> getAllOrder();

}
