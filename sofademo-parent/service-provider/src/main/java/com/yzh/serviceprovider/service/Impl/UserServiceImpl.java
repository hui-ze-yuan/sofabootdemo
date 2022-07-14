package com.yzh.serviceprovider.service.Impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzh.common.Result;
import com.yzh.common.Service.UserService;
import com.yzh.common.entity.User;
import com.yzh.serviceprovider.mapper.UserMapper;
import com.yzh.serviceprovider.utils.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
@SofaService(interfaceType = UserService.class,uniqueId = "userService",
        bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService   {

    @Resource
    private UserMapper userMapper;


    @DS("master")//指定所操作的数据源
    @Override
    public void UpdateUserInfo(User user) {
        log.info(user.toString());
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username",user.getUsername());
//        updateWrapper.set("age",user.getAge());
//        updateWrapper.set("sex",user.getSex());
//        updateWrapper.set("email",user.getEmail());
//        updateWrapper.set("phone",user.getPhone());
//        updateWrapper.set("password",Md5Util.md5(user.getPassword()));
        userMapper.update(user,updateWrapper);
    }
    @DS("master")
    @Override
    public Object AddUser(User user) {
        //先判断是否有该用户， id及用户名唯一
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if (res != null) {
            return Result.error("-1", "用户名重复");
        }
        User userInfo = User.builder()
                .username(user.getUsername())
                .password(Md5Util.md5(user.getPassword()))
                .age(user.getAge())
                .email(user.getEmail())
                .phone(user.getPhone())
                .sex(user.getSex())
                .build();
        userMapper.insert(userInfo);
        return  Result.success();
    }

    @DS("master")
    @Override
    public void deleteUser(int userId) {
        userMapper.deleteById(userId);
    }

    @DS("slave_1")
    @Override
    public User findUserInfoById(int userId) {
        return userMapper.selectById(userId);
    }

    @DS("slave_1")
    @Override
    public List<User> findAllUsers() {
        return userMapper.selectList(null);
    }

    @DS("slave_1")
    @Override
    public User findUserByUsername(String name) {
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, name));
    }


}
