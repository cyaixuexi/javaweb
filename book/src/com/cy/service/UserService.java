package com.cy.service;

import com.cy.pojo.User;

public interface UserService {

    //注册用户
    public void registUser(User user);

    //登录
    /*
    * 如果返回null 说明登陆失败 返回有值 说明登录成功
    * */
    public User login(User user);

    //检查用户是否可用
    /*
    * 返回true表示用户名已存在  返回false表示用户名可用
    * */
    public boolean existsUsername(String username);
}
