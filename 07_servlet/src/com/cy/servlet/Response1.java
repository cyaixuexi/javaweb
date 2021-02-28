package com.cy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游 response1");

        /*//设置响应状态码 302 ，表示重定向 （已搬迁）
        resp.setStatus(302);

        //设置响应头 说明新的地址在哪里
        resp.setHeader("Location","http://localhost:8080/07_servlet/response2");*/

        resp.sendRedirect("http://localhost:8080/07_servlet/response2");

    }
}
