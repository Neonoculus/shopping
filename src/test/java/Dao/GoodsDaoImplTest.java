package Dao;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import domain.Goods;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GoodsDaoImplTest {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Test
    public void addTest(){
        Goods goods = new Goods(1000003,101,10001,"垃圾游戏","#",3000.0,"真的是垃圾游戏不骗你",1,200000);
        int res=goodsDao.add(goods);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        int id=1000003;
        int res = goodsDao.delete(id);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void updateTest(){
        Goods goods = new Goods(1000003,101,10001,"我真的不是垃圾游戏","#",3000.0,"真的不是垃圾游戏啊",1,200000);
        int res=goodsDao.update(goods);
        if(res==1) System.out.println("修改成功");
        else System.out.println("修改失败");
    }
    @Test
    public void getGoodsByGIdTest(){
        int id=1000001;
        Goods goods=goodsDao.getGoodsByGId(id);
        System.out.println(goods);
    }
    @Test
    public void getGoodsByCIdTest(){
        int id=101;
        List<Goods> goods=goodsDao.getGoodsByCId(id);
        for (Goods goods1 : goods)
            System.out.println(goods1);
    }
    @Test
    public void getGoodsByMIdTest(){
        int id=10001;
        List<Goods> goods=goodsDao.getGoodsByMId(id);
        for (Goods goods1 : goods)
            System.out.println(goods1);
    }
    @Test
    public void getGoodsByNameTest(){
        String name="机械";
        List<Goods> goods=goodsDao.getGoodsByName(name);
        for (Goods goods1 : goods)
            System.out.println(goods1);
    }
    @Test
    public void getGoodsByPriceTest(){
        Double min = 100.0;
        Double max = 400.0;
        List<Goods> goods=goodsDao.getGoodsByPrice(min,max);
        for (Goods goods1 : goods)
            System.out.println(goods1);
    }
    @Test
    public void getGoodsByStatusTest(){
        int status=1;
        List<Goods> goods=goodsDao.getGoodsByStatus(status);
        for (Goods goods1 : goods)
            System.out.println(goods1);
    }
    @Test
    public void getAllGoodsTest(){
        List<Goods> goods = goodsDao.getAllGoods();
        for(Goods goods1 : goods){
            System.out.println(goods1);
        }
    }
}
