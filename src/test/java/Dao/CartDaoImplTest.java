package Dao;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import domain.Cart;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CartDaoImplTest {
    private CartDao cartDao = new CartDaoImpl();
    @Test
    public void addTest(){
        Cart cart = new Cart(1000001,100001,3,450.0,1);
        int res = cartDao.add(cart);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        Cart cart = new Cart(1000001,100001,3,450.0,1);
        int res = cartDao.delete(cart);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void updateTest(){
        Cart cart = new Cart(1000001,100001,10,1500.0,1);
        int res = cartDao.update(cart);
        if(res==1) System.out.println("修改成功");
        else System.out.println("修改失败");
    }
    @Test
    public void getCartByBIdTest(){
        int id = 100001;
        List<Cart> carts = cartDao.getCartByBId(id);
        for (Cart cart : carts)
        {
            System.out.println(cart);
        }
    }
    @Test
    public void getAllCartTest(){
        List<Cart> carts = cartDao.getAllCart();
        for (Cart cart : carts)
        {
            System.out.println(cart);
        }
    }
}

