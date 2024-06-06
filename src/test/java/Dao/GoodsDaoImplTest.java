package Dao;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import domain.Goods;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImplTest {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Test
    public void addTest(){
        Goods goods = new Goods(1000005,101,10001,"垃圾游戏","#",3000.0,"真的是垃圾游戏不骗你",1,200000);
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
        Goods goods = new Goods(1000003,102,10002,"我真的不是垃圾游戏","#",3000.0,"真的不是垃圾游戏啊",1,200000);
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
    public void findByPageTest(){
        int start=0;
        int rows=2;
        List<Goods> goods=goodsDao.findByPage(start,rows);
        for (Goods good : goods)
            System.out.println(good);
    }
    @Test
    public void getAllGoodsTest(){
        List<Goods> goods = goodsDao.getAllGoods();
        for(Goods goods1 : goods){
            System.out.println(goods1);
        }
    }
    @Test
    public void getGoodsByCIdAndTidsTest(){
        List<Integer> Tids=new ArrayList<>();
        Tids.add(15);
        Tids.add(12);
        List<Goods> goods = goodsDao.getGoodsByCIdAndTids(103,Tids);
        for(Goods goods1 : goods){
            System.out.println(goods1);
        }
    }

    @Test
    public void getGoodsByCIdAndTidsAndPriceTest(){
        List<Integer> Tids=new ArrayList<>();
        Tids.add(15);
        Tids.add(12);
        Double minPrice=200.0;
        Double maxPrice=6000.0;
        List<Goods> goods = goodsDao.getGoodsByCIdAndTidsAndPrice(103,Tids,minPrice,maxPrice);
        for(Goods goods1 : goods){
            System.out.println(goods1);
        }
    }
    @Test
    public void getGoodByAllQueryTest(){
       String word="手";
        List<Goods> goods = goodsDao.getGoodByAllQuery(word);
        for(Goods goods1 : goods){
            System.out.println(goods1);
        }
    }
}
