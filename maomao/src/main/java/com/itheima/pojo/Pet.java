package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private int id;

    @NotBlank(message = "宠物名不能为空")
    private String name;

    private String kind;

    @Pattern(regexp = "^(在售|已售出)$", message = "状态必须为'在售'或'已售出'")
    private String state;//只有两种状态 "在售" "已售出"
}
