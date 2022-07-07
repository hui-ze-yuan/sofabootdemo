package com.yzh.common.Service;



import com.yzh.common.entity.User;

import java.util.List;

public interface UserService {


    /**
     * 更新用户信息
     * @param user
     * @return
     */
    void UpdateUserInfo(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Object AddUser( User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(int userId);

    /**
     * 根据用户id查找用户
     * @param userId
     * @return
     */
    User findUserInfoById(int userId);

    /**
     * 查找所有用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 根据用户名查找用户
     * @param name
     * @return
     */
    User findUserByUsername(String name);

}
