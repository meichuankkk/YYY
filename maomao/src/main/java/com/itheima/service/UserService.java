package com.itheima.service;

import com.itheima.pojo.Event;
import com.itheima.pojo.User;
import java.util.List;

public interface UserService {
    User getOwner(String userName);

    List<Event> getEvent(String userName);

    void register(User user);

    public boolean isUsernameExists(String username);

    User login(User user);

    void addUser(User user);

    User getById(Integer id);


    void changeUser(User user);
}
