package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("正在验证用户：{}",user.getUsername());
        User e=userService.login(user);

        //登陆成功，生成令牌，下发令牌
        if(e!=null){
            Map<String, Object> claims=new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getUsername());
            claims.put("username",e.getUsername());
            String jwt=JwtUtils.generateJwt(claims);//jwt就包含了当前信息
            return Result.success(jwt);
        }
        //

        return  e!=null?Result.success():Result.error("用户名或密码错误！");
    }

}
