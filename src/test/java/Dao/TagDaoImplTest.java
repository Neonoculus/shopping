package Dao;

import dao.TagDao;
import dao.impl.TagDaoImpl;
import domain.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TagDaoImplTest {
    private TagDao tagDao = new TagDaoImpl();
    @Test
    public void addTest(){
        Tag tag = new Tag(11,"303");
        int res=tagDao.add(tag);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        int id=11;
        int res = tagDao.delete(id);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void updateTest(){
        Tag tag = new Tag(11,"66");
        int res=tagDao.update(tag);
        if(res==1) System.out.println("修改成功");
        else System.out.println("修改失败");
    }
    @Test
    public void getTagByTIdTest(){
        int id=11;
        Tag tag=tagDao.getTagByTId(id);
        System.out.println(tag);
    }
    @Test
    public void getGoodsByNameTest(){
        String name="男";
        List<Tag> tags=tagDao.getTagByName(name);
        for (Tag tag : tags)
            System.out.println(tag);
    }
    @Test
    public void getAllGoodsTest(){
        List<Tag> tags = tagDao.getAllTag();
        for(Tag tag : tags){
            System.out.println(tag);
        }
    }
}
