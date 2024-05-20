package com.itheima.service;

import com.itheima.pojo.Event;
import com.itheima.pojo.User;

public interface EventService {
    Event getEvent(String eventName);

    User getOwner(String eventName);
}
