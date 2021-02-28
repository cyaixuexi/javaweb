package com.cy.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        1 getRequestURI()         获取请求的资源路径
        System.out.println("uri-->"+req.getRequestURI());
        //        2 getRequestURL()         获取请求的统一资源定位符
        System.out.println("urL-->"+req.getRequestURL());
        //        3 getRemoteHost()            获取客户端的IP地址
        /*在IDEA中，使用Localhost访问时，得到客户端IP地址值是==》 127.0.0.1
         *
         * */
        System.out.println("客户端IP地址-->"+req.getRemoteHost());
        //        4 getHeader()             获取请求头
        System.out.println("请求头User—Agent-->"+req.getHeader("User-Agent"));
        //        5 getMethod()             获取请求方式 GET或POST
        System.out.println("请求的方式-->"+req.getMethod());
    }
}