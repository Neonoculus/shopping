package Dao;

import dao.CategoryTagDao;
import dao.impl.CategoryTagDaoImpl;
import domain.CategoryTag;
import domain.GoodsTag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CategoryTagDaoImplTest {
    CategoryTagDao categoryTagDao = new CategoryTagDaoImpl();
    @Test
    public void addTest(){
        CategoryTag categoryTag = new CategoryTag(101,10);
        int res=categoryTagDao.add(categoryTag);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        int c_id = 101;
        int t_id = 10;
        int res = categoryTagDao.delete(c_id,t_id);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void getCategoryTagByCidTest(){
        int id=1000001;
        List<CategoryTag> categoryTags=categoryTagDao.getCategoryTagByCid(id);
        for (CategoryTag categoryTag : categoryTags)
            System.out.println(categoryTag);
    }
    @Test
    public void getAllCategoryTag(){
        List<CategoryTag> categoryTags = categoryTagDao.getAllCategoryTag();
        for(CategoryTag categoryTag : categoryTags){
            System.out.println(categoryTag);
        }
    }
}
