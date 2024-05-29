package dao;

import domain.Login;

public interface LoginDao {
    void add(Login login);
    void delete(int id);
    void update(Login login,int id);
    Login idSelect(int id);
    Boolean Login(String username,String password);
    Login[] Select();

}

