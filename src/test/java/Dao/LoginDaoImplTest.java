package Dao;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import domain.Login;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LoginDaoImplTest {
    private final LoginDao loginDao = new LoginDaoImpl();
    @Test
    public void addTest(){
        Login login = new Login(100000003,"1","1",3,10001);
        int res=loginDao.add(login);
        if(res==1) System.out.println("增加成功");
        else System.out.println("增加失败");
    }
    @Test
    public void deleteTest(){
        int id=1000000003;
        int res = loginDao.delete(id);
        if(res==1) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
    @Test
    public void updateTest(){
        Login login = new Login(100000003,"3","3",3,10001);
        int res=loginDao.update(login);
        if(res==1) System.out.println("修改成功");
        else System.out.println("修改失败");
    }
    @Test
    public void getLoginByIdTest(){
        int id=10001;
        Login login=loginDao.getLoginById(id);
        System.out.println(login);
    }
    @Test
    public void loginTest(){
        String username = "3";
        String password = "3";
        //String password = "2";
        System.out.println(loginDao.Login(username,password));
    }
    @Test
    public void getAllGoodsTest(){
        List<Login> logins = loginDao.getAllLogin();
        for(Login login : logins){
            System.out.println(login);
        }
    }
}
