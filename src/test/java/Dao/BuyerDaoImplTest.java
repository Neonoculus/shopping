package Dao;

import dao.BuyerDao;
import dao.impl.BuyerDaoImpl;
import domain.Buyer;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BuyerDaoImplTest {
    private final BuyerDao buyerDao = new BuyerDaoImpl();
    @Test
    public void addTest(){
        Buyer buyer = new Buyer(100001,"吕","qq.com","地球","123123123","img/k");
        int res=buyerDao.add(buyer);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        int id=100001;
        int res = buyerDao.delete(id);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void updateTest(){
        Buyer buyer = new Buyer(100001,"王博宁","qq.com","地球","8208208820","img/k");
        int res=buyerDao.update(buyer);
        if(res==1) System.out.println("修改成功");
        else System.out.println("修改失败");
    }
    @Test
    public void getBuyerByBidTest(){
        int id=100001;
        Buyer buyer=buyerDao.getBuyerByBId(id);
        System.out.println(buyer);
    }
    @Test
    public void getBuyerByNameTest(){
        String name = "王";
        List<Buyer> buyers = buyerDao.getBuyerByName(name);
        System.out.println(buyers.get(0));
    }
    @Test
    public void getBuyerByEmailTest(){
        String email = "qq.com";
        Buyer buyer = buyerDao.getBuyerByEmail(email);
        System.out.println(buyer);
    }
    @Test
    public void getBuyerByPhoneTest(){
        String phone = "8208208820";
        Buyer buyer = buyerDao.getBuyerByPhone(phone);
        System.out.println(buyer);
    }
    @Test
    public void getAllBuyerTest(){
        List<Buyer> buyers = buyerDao.getAllBuyer();
        for(Buyer buyer : buyers){
            System.out.println(buyer);
        }
    }
}
