package com.ev.blog.service.impl;

import com.ev.blog.dao.UserDao;
import com.ev.blog.pojo.User;
import com.ev.blog.service.UserService;
import com.ev.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User checkUser(String username, String password) {
        return userDao.queryByUsernameAndPassword(username,MD5Utils.code(password));
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
