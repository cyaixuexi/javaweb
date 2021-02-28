package com.cy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParamaterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String password = req.getParameter("password");
        //  设置请求体的字符集为UTF-8 从而解决post请求的中文乱码
        //在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        //获取请求的参数
        String username = req.getParameter("username");

        //多个值  用getParameterValues
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("兴趣爱好："+ Arrays.asList(hobby));

    }
}
