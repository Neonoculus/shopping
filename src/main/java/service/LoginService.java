package service;

import domain.Login;

import java.util.List;

public interface LoginService {
    int add(Login login);
    int delete(int id);
    int update(Login login);
    Login getLoginById(int id);
    Boolean Login(String username,String password);
    List<Login> getAllLogin();

}

