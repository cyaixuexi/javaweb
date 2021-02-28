package com.cy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("cy".equals(username)&&"123".equals(password)){
            //登录成功
            Cookie cookie = new Cookie("username",username);
            cookie.setMaxAge(60*60*7*24);//当前cookie一周内有效
            resp.addCookie(cookie);
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}
