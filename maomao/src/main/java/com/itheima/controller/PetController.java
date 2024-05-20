package com.itheima.controller;

import com.itheima.pojo.Pet;
import com.itheima.pojo.Result;
import com.itheima.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PetController {
    @Autowired
    private PetService petService;

    // 验证id是否为整数类型的方法
    public boolean isValidId(String id) {
        // 使用正则表达式验证是否为整数
        return id.matches("\\d+");
    }

    @GetMapping("/pet/{id}")
    public Result searchPet(@PathVariable String id){
        try {
            // 将id转换为整数类型
            int petId = Integer.parseInt(id);
            log.info("现在在查询id：{}的宠物",id);

            // 调用service层方法查找宠物
            Pet pet = petService.searchPet(petId);

            if (pet != null) {
                return Result.success(pet);
            }
        } catch (NumberFormatException e) {
            // 如果无法将字符串转换为整数，返回错误消息
            return Result.error("ID格式不正确！");
        }

        return Result.error("记录不存在！");
    }

    @PostMapping("/pet")
    public Result addPet(@RequestBody Pet pet){
        log.info("新增在售宠物：{}",pet.getName());
        petService.addPet(pet);
        return Result.success();
    }

    @PutMapping("/pet")
    public Result modifyPet(@Valid @RequestBody Pet pet, BindingResult bindingResult){

        //这里是如果后端来进行
        //如果是前端用下拉框来选择是否售出 就不需要了
        if (bindingResult.hasErrors()) {
            // 如果验证失败，生成自定义的错误信息
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            // 返回自定义的错误信息
            return Result.error("格式错误", errors);
        }

        // 这里可以直接调用 PetService 的 modifyPet 方法
        petService.modifyPet(pet);

        return Result.success();
    }

    @DeleteMapping("/pet/{id}")
    public Result deletePet(@PathVariable int id){
        log.info("正在删除id为{}的宠物",id);
        petService.deletePet(id);
        return Result.success("删除成功");
    }

    @GetMapping("/pet/search/{state}")
    //这里如果是1，就代表在售，如果是2 就代表已售出
    public Result searchCorrPet(@PathVariable int state){
        List<Pet> petList=petService.searchCorrPet(state);
        return Result.success(petList);
    }
}
