package Dao;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import domain.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static utils.Date.StringGoDate;

public class OrderDaoImplTest {
    private OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void addTest(){
        Order order = new Order(1000001,100001,"派大星","123456","比奇堡大石头",500.0,StringGoDate("2024-05-30 12:00:00"),null,1);
        int res=orderDao.add(order);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        int id=1000003;
        int res = orderDao.delete(id);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void updateTest(){
        Order order = new Order(1000001,100001,"海绵宝宝","123456","比奇堡大石头",500.0,StringGoDate("2024-05-30 12:00:00"),null,1);
        int res=orderDao.update(order);
        if(res==1) System.out.println("修改成功");
        else System.out.println("修改失败");
    }
    @Test
    public void getOrderByBIdTest(){
        int id=100001;
        List<Order> orders =orderDao.getOrderByBId(id);
        for (Order order : orders)
           System.out.println(order);
    }
    @Test
    public void getOrderByOIdTest(){
        int id=1000001;
        Order order =orderDao.getOrderByOId(id);
        System.out.println(order);
    }
    @Test
    public void getAllOrderTest(){
        List<Order> orders = orderDao.getAllOrder();
        for(Order order : orders){
            System.out.println(order);
        }
    }
}
