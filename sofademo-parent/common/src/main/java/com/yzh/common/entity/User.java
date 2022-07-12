package com.yzh.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author hui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user1")
public class User {
//    @TableId(type = IdType.ASSIGN_UUID)  185fd43e050acf460e2b2579ae64333d
    @TableId(type = IdType.ASSIGN_ID)  // String  2f7b5a45751601852a098c2330fe0cfb
    private Long userId;
    private String username;
    private String password;
    private String sex;
    private int age;
    private String email;
    private String phone;
}
