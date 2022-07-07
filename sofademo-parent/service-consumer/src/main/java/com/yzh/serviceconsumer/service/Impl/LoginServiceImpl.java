package com.yzh.serviceconsumer.service.Impl;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.example.sofademocommon.Result;
import com.example.sofademocommon.Service.LoginService;
import com.example.sofademocommon.Service.UserService;
import com.example.sofademocommon.entity.User;
import com.yzh.serviceprovider.utils.Md5Util;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component

@Service
public class LoginServiceImpl implements LoginService {

    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"), uniqueId = "userService")
    private UserService userService;

    @Override
    public Object login(String username, String password) {
        System.out.println("username" + username + "\n" + "password" + password);
        if (!username.isEmpty() && !password.isEmpty()) {
            //用户存在判断
            User user = userService.findUserByUsername(username);
            if (user == null) {
                return Result.error("-1", "用户不存在");
            }
            //密码判断
            if (user.getPassword().equals(Md5Util.md5(password))) {
                return Result.success(user);
            } else return Result.error("-1", "密码错误");
        }else return Result.error("-1", "用户名或密码为空");

    }

}
