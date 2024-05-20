package com.itheima.controller;

import com.itheima.pojo.*;
import com.itheima.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/UserInformationSerarch/{userName}")
    public Result getInforma(@PathVariable String userName ){
        log.info("现在正在查询用户:{}的基本信息",userName);
        User user=userService.getOwner(userName);
        List<Event> event=userService.getEvent(userName);
        // 创建一个包含用户和事件信息的数据对象
        EventData responseData = new EventData(); // 假设这里为用户和事件信息创建了一个新的对象
        responseData.setUser(user);
        responseData.setEvent(event);
        return Result.success(responseData);
    }


    @PutMapping("/Users")
    public Result changaYuanGong(@RequestBody User user){
        log.info("正在修改用户基本信息：{}",user.getUsername());
        userService.changeUser(user);
        return Result.success();
    }
}
