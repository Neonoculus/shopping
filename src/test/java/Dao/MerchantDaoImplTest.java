package Dao;

import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;
import domain.Merchant;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MerchantDaoImplTest {
    MerchantDao merchantDao = new MerchantDaoImpl();
    @Test
    public void addTest(){
        Merchant merchant = new Merchant(10002,"任天堂水管工","911","洛克王国","666@qq.com","#","来自洛克王国的水管工");
        int res=merchantDao.add(merchant);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        int id = 10002;
        int res=merchantDao.delete(id);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void updateTest(){
        Merchant merchant = new Merchant(10002,"任天堂水管工","911","赛尔号","666@qq.com","#","来自赛尔号的水管工");
        int res=merchantDao.update(merchant);
        if(res==1) System.out.println("修改成功");
        else System.out.println("修改失败");
    }
    @Test
    public void getMerchantByMIdTest(){
        int id=10001;
        Merchant merchant=merchantDao.getMerchantByMId(id);
        System.out.println(merchant);
    }
    @Test
    public void getMerchantByNameTest(){
        String name = "索";
        List<Merchant> merchants = merchantDao.getMerchantByName(name);
        for (Merchant merchant : merchants)
        {
            System.out.println(merchant);
        }
    }
    @Test
    public void getMerchantByPhoneTest(){
        String phone="10086";
        Merchant merchant=merchantDao.getMerchantByPhone(phone);
        System.out.println(merchant);
    }
    @Test
    public void getMerchantByEmailTest(){
        String email="10001@qq.com";
        Merchant merchant=merchantDao.getMerchantByEmail(email);
        System.out.println(merchant);
    }
    @Test
    public void getAllMerchantTest(){
        List<Merchant> merchants = merchantDao.getAllMerchant();
        for(Merchant merchant : merchants){
            System.out.println(merchant);
        }
    }
}
