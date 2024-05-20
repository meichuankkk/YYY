package com.itheima.controller;

import com.itheima.pojo.Event;
import com.itheima.pojo.EventData;
import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/EventInformationSerarch/{eventName}")
    public Result getInforma(@PathVariable String eventName ){
        log.info("现在正在查询事件:{}的信息和作者信息",eventName);
        User user=eventService.getOwner(eventName);
        Event event=eventService.getEvent(eventName);
        // 创建一个包含用户和事件信息的数据对象
        EventData responseData = new EventData(); // 假设这里为用户和事件信息创建了一个新的对象
        responseData.setUser(user);
        responseData.setEvent(event);
        return Result.success(responseData);
    }

}
