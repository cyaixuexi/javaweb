package com.cy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数（办事的材料） 查看
        String username = req.getParameter("username");
        System.out.println("在Servlet2中查看参数。。。"+username);

        //查看servlet1是否有盖章
        Object key = req.getAttribute("key");
        System.out.println("servlet1是否盖章："+key);

        //处理自己的业务
        System.out.println("servlet2  处理自己的业务");
    }
}
