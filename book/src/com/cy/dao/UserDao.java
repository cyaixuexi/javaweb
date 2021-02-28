package com.cy.dao;

import com.cy.pojo.User;

public interface UserDao  {

    /*
    //根据用户名查询用户信息
    如果返回null   说明没有这个用户 反之亦然
     * */
    public User queryUserByUsername(String username);

    /*
        //根据用户名查询用户信息
        如果返回null   说明用户名或密码错误
         * */
    public User queryUserByUsernameAndPassword(String username,String password);

    /*
    * 保存用户信息
    * */
    public int saveUser(User user);
}
