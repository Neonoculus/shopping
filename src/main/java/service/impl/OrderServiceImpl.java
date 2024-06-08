package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import domain.Order;
import service.OrderService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    public List<Order> getOrderByOId(long id) {
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
    public List<Order> findByPage(int start, int rows) {
        return orderDao.findByPage(start,rows);
    }

    @Override
    public int[] OrderAmountNumber(List<Order> orders) {
        int length = orders.size();
        int todayLength = 0;
        LocalDateTime today = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);

        for(Order order:orders)
        {
            if (order.getStartTime().toLocalDate().isEqual(today.toLocalDate())) {
                todayLength++;
            }
        }
        return new int[]{length,todayLength};
    }

    @Override
    public Double[] OrderMoneyNumber(List<Order> orders) {
        Double sum = 0.0;
        Double todaySum = 0.0;
        LocalDateTime today = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        for(Order order:orders)
        {
            if (order.getStartTime().toLocalDate().isEqual(today.toLocalDate())) {
                todaySum=todaySum+order.getMoney();
            }
            sum=sum+order.getMoney();
        }
        return new Double[]{sum,todaySum};
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDao.getAllOrder();
    }
}
