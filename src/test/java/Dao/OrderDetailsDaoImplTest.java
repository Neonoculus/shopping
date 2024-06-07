package Dao;

import dao.OrderDetailsDao;
import dao.impl.OrderDetailsDaoImpl;
import domain.OrderDetails;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderDetailsDaoImplTest {
    private OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();
    @Test
    public void addTest(){
        OrderDetails orderDetails = new OrderDetails(1000001,1000001,2,500.0);
        int res=orderDetailsDao.add(orderDetails);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        int g_id=1000001;
        int o_id=1000001;
        int res = orderDetailsDao.delete(g_id,o_id);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void updateTest(){
        OrderDetails orderDetails = new OrderDetails(1000001,1000001,3,750.0);
        int res=orderDetailsDao.update(orderDetails);
        if(res==1) System.out.println("修改成功");
        else System.out.println("修改失败");
    }
    @Test
    public void getOrderDetailsByOIdTest(){
        int id=1000001;
        List<OrderDetails> orderDetails=orderDetailsDao.getOrderDetailsByOId(id);
        for (OrderDetails orderDetails1 : orderDetails)
            System.out.println(orderDetails1);
    }
    @Test
    public void getAllOrderDetailsTest(){
        List<OrderDetails> orderDetails = orderDetailsDao.getAllOrderDetails();
        for(OrderDetails orderDetails1 : orderDetails){
            System.out.println(orderDetails1);
        }
    }

    @Test
    public  void getOrderDetailsByMIdAndOIdTest(){
        int m_id =10001;
        long o_id = 1;
        List<OrderDetails> orderDetails = orderDetailsDao.getOrderDetailsByMIdAndOId(m_id,o_id);
        for(OrderDetails orderDetails1 : orderDetails){
            System.out.println(orderDetails1);
        }
    }
}
