package com.cy.test;

import com.cy.pojo.User;
import com.cy.service.UserService;
import com.cy.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"小心","123321","xiaoxin@qq.com"));
        userService.registUser(new User(null,"小王","2468","xiaowang@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"小心","123321",null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("111")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用！");
        }
    }
}