package com.yzh.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class User {
    //主键 id 自动递增
    @TableId(type = IdType.AUTO)
    private int userId;
    private String username;
    private String password;
    private String sex;
    private int age;
    private String email;
    private String phone;
}
