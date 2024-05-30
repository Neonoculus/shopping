package Dao;

import dao.LikeDao;
import dao.impl.LikeDaoImpl;
import domain.Like;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LikeDaoImplTest {
    private LikeDao likeDao = new LikeDaoImpl();
    @Test
    public void addTest(){
        Like like = new Like(1000001,100001);
        int res=likeDao.add(like);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        int id=1000003;
        int res = likeDao.delete(id);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void getLikeByBIdTest(){
        int id=100001;
        List<Like> likes =likeDao.getLikeByBId(id);
        for (Like like1 : likes)
           System.out.println(like1);
    }
    @Test
    public void getAllLikeTest(){
        List<Like> likes =likeDao.getAllLike();
        for (Like like1 : likes)
            System.out.println(like1);
    }
}
