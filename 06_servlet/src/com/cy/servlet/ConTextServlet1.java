package com.cy.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ConTextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext = getServletContext();

        servletContext.setAttribute("key1","value1");

        System.out.println("Context1中或区域数据key1的值是："+servletContext.getAttribute("key1"));
    }

}
