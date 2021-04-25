package com.Service;

import com.Dao.UserDao;
import com.Dao.impl.UserDaoImpl;
import com.Entity.User;

import java.util.Random;

public class UserService {
    private UserDao userDao=new UserDaoImpl();

    public User queryUser(String username, String password) {
        return userDao.queryUser(username,password);
    }

    public void insert(User user) {
         userDao.insert(user);
    }
}
