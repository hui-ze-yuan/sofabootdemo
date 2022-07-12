package com.yzh.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author hui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
public class Book {
    /**
     *     默认为雪花算法生成的id     1546736372961357825  Long   19位  对应数据库 BIGINT（20）
     *     前端接收不了19位精度，可以自定义16位长度的id
     *      换成String 2f7b5a45751601852a098c2330fe0cfb  对应varchar（32）
     *      特点：随时间递增,不冲突，
     */
    @TableId(type = IdType.ASSIGN_ID)
    public Long id;
    public String name;
    public double price;
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    public String createBy;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    public Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    public Date updateTime;

}
