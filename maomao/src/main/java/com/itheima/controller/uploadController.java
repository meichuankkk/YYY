package com.itheima.controller;


import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class uploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, @RequestParam("image") MultipartFile image) throws IOException {
        log.info("文件上传：{},{},{}",username,age,image);
        //获取原始文件名
        String orginName=image.getOriginalFilename();

        //获取文件类型，以及随机文件名UUID
        int index=orginName.lastIndexOf(".");
        String extname=orginName.substring(index);
        String newName= UUID.randomUUID().toString()+extname;
        log.info("新的文件名："+newName);

        //把文件存在指定的文件夹
        image.transferTo(new File("E:\\A_li_pan\\"+newName));

        return Result.success();
    }
}
