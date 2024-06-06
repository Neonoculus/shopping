package dao;

import domain.Login;

import java.util.List;

public interface LoginDao {
    int add(Login login);
    int delete(int id);
    int update(Login login);
    Login getLoginById(int id);
    Login Login(String username,String password);
    List<Login> getAllLogin();

}

