package com.yzh.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
public class Book {
    @TableId(type = IdType.AUTO)
    public int id;
    public String name;
    public double price;
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    public String createBy;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    public Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    public Date updateTime;

}
