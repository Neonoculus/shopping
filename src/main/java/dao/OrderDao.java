package dao;

import domain.Order;

public interface OrderDao {
    void add(Order order);
    void delete(int id);
    void update(Order order,int id);
    Order oIdSelect(long id);
    Order[] bIdSelect(int id);
    Order[] Select();
}
