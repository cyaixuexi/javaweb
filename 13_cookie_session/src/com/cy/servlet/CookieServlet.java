package com.cy.servlet;

import com.cy.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet{
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1","path1");
        //getContextPath()  ===>> 得到工程路径
        cookie.setPath(req.getContextPath()+"/abc");    //工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的cookie!");
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie =new Cookie("life3600","life3600");
        cookie.setMaxAge(60*60);//设置cookie一小时之后删除 无效
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的cookie!");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie =new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //先找到你要删除的cookie对象
        Cookie cookie =CookieUtils.findCookie("key1",req.getCookies()) ;
        if (cookie != null) {
            cookie.setMaxAge(0);// 表示马上删除，都不需要等待浏览器关闭
            resp.addCookie(cookie);
        }

        resp.getWriter().write("key1的Cookie已经被删除!");

    }
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方案一：
        //1，先创建一个需要修改的同名的Cookie对象
        //2，在构造器中，同时赋予新的值
        Cookie cookie = new Cookie("key1","newValue1");
        //3，调用response.addCookie(Cookie)    通知客户端 保存修改
        resp.addCookie(cookie);

        //方案二：
        //1，先查找到需要修改的cookie对象
        Cookie cookie1 = CookieUtils.findCookie("key2",req.getCookies());
        if (cookie1!=null){
            //2，调用setValue()方法赋予新的cookie值
            cookie1.setValue("newValue2");
            //3，调用response.addCookie()方法 通知客户端保存修改
            resp.addCookie(cookie1);
        }


        resp.getWriter().write("key1的cookie已经修改好了！");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //getName方法返回cookie的key值
            //getValue方法返回cookie的value值
            resp.getWriter().write("cookies["+cookie.getName()+"="+cookie.getValue()+"] <br>" );
        }
        Cookie  iwnatCookie = CookieUtils.findCookie("key1",cookies);

        //如果不等于NULL，说明赋过值了，也就找到了需要的cookie
        if (iwnatCookie!=null){
            resp.getWriter().write("找到了需要的cookie");
        }
    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 创建Cookie对象
         Cookie cookie = new Cookie("key1","value1");
        //2 通知客户端保存
        resp.addCookie(cookie);
        Cookie cookie1 = new Cookie("key2","value2");
        //2 通知客户端保存
        resp.addCookie(cookie1);

        resp.getWriter().write("Cookie创建成功!");
    }
}
