package com.itheima.service.impl;

import com.itheima.mapper.EventMapper;
import com.itheima.pojo.Event;
import com.itheima.pojo.User;
import com.itheima.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventSeriveImp implements EventService {
    @Autowired
    private EventMapper eventMapper;

    @Override
    public Event getEvent(String eventName) {
        return eventMapper.getEvent(eventName);
    }

    @Override
    public User getOwner(String eventName) {
        return eventMapper.getOwner(eventName);
    }
}
