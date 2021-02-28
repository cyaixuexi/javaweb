package com.cy.test;


import com.cy.dao.UserDao;
import com.cy.dao.impl.UserDaoImpl;
import com.cy.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("111")==null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");

        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("111","111")==null){
            System.out.println("用户名或密码错误！");
        }else{
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"小明","123","123@qq.com")));
    }
}