package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import domain.Order;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    @Override
    public int add(Order order) {
        return orderDao.add(order);
    }

    @Override
    public int delete(int id) {
        return orderDao.delete(id);
    }

    @Override
    public int update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public Order getOrderByOId(long id) {
        return orderDao.getOrderByOId(id);
    }

    @Override
    public List<Order> getOrderByBId(int id) {
        return orderDao.getOrderByBId(id);
    }

    @Override
    public List<Order> getOrderByMId(int id) {
        return orderDao.getOrderByMId(id);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDao.getAllOrder();
    }
}
