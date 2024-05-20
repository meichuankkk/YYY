package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class registerController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        // 检查用户名是否已存在
        if (userService.isUsernameExists(user.getUsername())) {
            // 如果用户名已存在，返回用户名已存在的提示
            return Result.error("用户名已存在");
        } else {
            // 如果用户名不存在，进行用户注册
            log.info("正在注册用户：{}", user.getUsername());
            userService.register(user);
            return Result.success("注册成功");
        }
    }


}
