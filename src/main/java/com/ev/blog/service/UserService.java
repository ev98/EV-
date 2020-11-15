package com.ev.blog.service;


import com.ev.blog.pojo.User;

public interface UserService {

    User checkUser(String username,String password);

    User findByUsername(String username);
}
