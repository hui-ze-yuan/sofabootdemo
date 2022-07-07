package com.yzh.serviceprovider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sofademocommon.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {
//    @Update("Update user set age = #{age} where user_id = #{userId}")
//    int updateUserInfo1(@Param("age") int age ,@Param("userId")int userId);
}
