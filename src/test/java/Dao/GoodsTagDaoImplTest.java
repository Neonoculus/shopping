package Dao;

import dao.GoodsTagDao;
import dao.impl.GoodsTagDaoImpl;
import domain.GoodsTag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GoodsTagDaoImplTest {
    private GoodsTagDao goodsTagDao = new GoodsTagDaoImpl();
    @Test
    public void addTest(){
        GoodsTag goodsTag = new GoodsTag(10,1000001);
        int res=goodsTagDao.add(goodsTag);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        int g_id = 1000001;
        int t_id = 10;
        int res = goodsTagDao.delete(g_id,t_id);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void getGoodsTagByGIdTest(){
        int id=1000001;
        List<GoodsTag> goodsTags=goodsTagDao.getGoodsTagByGId(id);
        for (GoodsTag goodsTag : goodsTags)
            System.out.println(goodsTag);
    }
    @Test
    public void getGoodsTagByTIdTest(){
        int id=10;
        List<GoodsTag> goodsTags=goodsTagDao.getGoodsTagByTId(id);
        for (GoodsTag goodsTag : goodsTags)
            System.out.println(goodsTag);
    }
    @Test
    public void getAllGoodsTagTest(){
        List<GoodsTag> goodsTags = goodsTagDao.getAllGoodsTag();
        for(GoodsTag goodsTag : goodsTags){
            System.out.println(goodsTag);
        }
    }
}
