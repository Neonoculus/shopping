package service.impl;

import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String account, String password) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean isUserExisted(String key, String value) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void forbiddenUser(int userId, boolean forbidden) {

    }

    @Override
    public void updatePassword(String account, String password) {

    }

    @Override
    public void updateUser(User user) {

    }
}
