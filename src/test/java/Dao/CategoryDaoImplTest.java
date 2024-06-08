package Dao;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import domain.Category;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CategoryDaoImplTest {
    private final CategoryDao categoryDao = new CategoryDaoImpl();
    @Test
    public void add(){
        Category category = new Category(102,"任天堂");
        int res = categoryDao.add(category);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        Category category = new Category(102,"任天堂");
        int res = categoryDao.delete(category.getC_id());
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void updateTest(){
        Category category = new Category(102,"xbox");
        int res = categoryDao.update(category);
        if(res==1) System.out.println("修改成功");
        else System.out.println("修改失败");
    }
    @Test
    public void getCategoryByCIdTest(){
        int id = 101;
        Category categories = categoryDao.getCategoryByCId(id);
        System.out.println(categories);
    }
    @Test
    public void getCategoryByNameTest() {
        String name="手机";
        List<Category> categories = categoryDao.getCategoryByName(name);
        for (Category category : categories)
        {
            System.out.println(category);
        }
    }
    @Test
    public void getAllCategoryTest(){
        List<Category> categories = categoryDao.getAllCategory();
        for (Category category : categories)
        {
            System.out.println(category);
        }
    }

}
