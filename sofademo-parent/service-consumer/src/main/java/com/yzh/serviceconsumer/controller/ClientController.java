package com.yzh.serviceconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;

import com.yzh.common.Result;
import com.yzh.common.Service.BookService;
import com.yzh.common.Service.UserService;
import com.yzh.common.entity.User;
import com.yzh.serviceconsumer.service.Impl.LoginServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

  //开启全局回滚
//@Transactional
@GlobalTransactional
@RestController
public class ClientController {
    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"),uniqueId = "userService")
    private UserService userService;
    @Autowired
    private LoginServiceImpl loginService;


    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {
        return (Result<?>)  userService.AddUser(user);
    }

    @PostMapping("/login")
    public Result<?> login(@RequestBody JSONObject parmsInfo){
        String username = parmsInfo.getString("username");
        String password = parmsInfo.getString("password");
        return (Result<?>) loginService.login(username,password);
    }

    @GetMapping("/findAllUsers")
    public Result<?> findAllUsers(){
        return  Result.success(userService.findAllUsers());
    }

    @RequestMapping("/deteleByUserId")
    public Result<?> deteleByUserId(@RequestParam("userId") String userId){
        try{
            userService.deleteUser(Integer.parseInt(userId));
            return  Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return  Result.error("-1","删除失败");
        }
    }


      @RequestMapping("/updateUserInfo")
    public Result<?> updateUserInfo(@RequestBody User userParam){
        try{
            System.out.println(userParam.toString());
            userService.UpdateUserInfo(userParam);
            int  i = 1/0;
            return  Result.success();
        }catch (Exception e){
            /**
             *  必须在有 @GlobalTransactional下的
             *  代码下进行异常抛出，不然报错不会回滚
             */
           throw new  RuntimeException("保存订单失败！");
//            return  Result.error("-1","更新失败");
        }
    }



}
