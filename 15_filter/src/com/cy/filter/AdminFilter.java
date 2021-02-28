package com.cy.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("1,filter构造器方法AdminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2,filter初始化方法init(FilterConfig filterConfig)");
        //1 获取filter的名称filter—name的内容
        System.out.println("filter—name的值是:"+filterConfig.getFilterName());
        //2 获取web.xml中配置的init-param初始化参数
        System.out.println("初始化参数username的值是:"+filterConfig.getInitParameter("username"));
        //3 获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    /*
    * 专门用于拦截请求。可以做权限检查。
    * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3,filter过滤方法doFilter()");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession session = httpServletRequest.getSession();

        Object user = session.getAttribute("user");
        //如果等于null，说明还没有登录
        if (user==null){
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        }else {
            //让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4,filter销毁方法destroy()");
    }
}
