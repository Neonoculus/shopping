package service.impl;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import domain.Login;
import service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = new LoginDaoImpl();
    @Override
    public int add(Login login) {
        return loginDao.add(login);
    }

    @Override
    public int delete(int id) {
        return loginDao.delete(id);
    }

    @Override
    public int update(Login login) {
        return loginDao.update(login);
    }

    @Override
    public Login getLoginById(int id) {
        return loginDao.getLoginById(id);
    }

    @Override
    public Login Login(String username, String password) {
        return loginDao.Login(username,password);
    }

    @Override
    public List<Login> getAllLogin() {
        return loginDao.getAllLogin();
    }
}
