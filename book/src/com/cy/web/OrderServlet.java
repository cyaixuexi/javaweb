package com.cy.web;

import com.cy.pojo.Cart;
import com.cy.pojo.User;
import com.cy.service.OrderService;
import com.cy.service.impl.OrderServiceImpl;
import com.cy.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{
   private OrderService orderService = new OrderServiceImpl();
    /*
    * 生成订单
    * */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取UserID
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        System.out.println("OrderServlet程序在【" + Thread.currentThread().getName() + "】中");


        Integer userId = loginUser.getId();
        //调用orderService.createOrder(Cart,UserId) 生成订单

        String orderId = orderService.createOrder(cart, userId);

//        req.setAttribute("orderId",orderId);
        //请求转发到pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        req.getSession().setAttribute(" orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
