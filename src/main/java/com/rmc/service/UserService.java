package com.rmc.service;

import com.rmc.dao.UserDao;
import com.rmc.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public User getUserByUserName(String name){
        return userDao.getUserByUserName(name);
    }
}
