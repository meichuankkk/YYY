package com.itheima.service.impl;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Event;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getOwner(String userName) {
        return userMapper.getOwner(userName);
    }

    @Override
    public List<Event> getEvent(String userName) {
        return userMapper.getEvent(userName);
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }

    @Override
    public boolean isUsernameExists(String username) {
        return userMapper.isUsernameExists(username) != null;
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void changeUser(User user) {
        userMapper.changeUser(user);
    }
}
