package com.cy.web;

import com.cy.pojo.Book;
import com.cy.pojo.Cart;
import com.cy.pojo.CartItem;
import com.cy.service.BookService;
import com.cy.service.impl.BookServiceImpl;
import com.cy.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();
    /*
    * 加入购物车
    * */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        // 调用bookService.queryBookById:Book得到图书信息
        Book book = bookService.queryBookById(id);
        // 把图书信息，转化为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        // 调用Cart.addItem(CartItem) 添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        // 重定向回原来商品所在的页面
        resp.sendRedirect(req.getHeader("Referer"));

        //最后一个添加商品的名称
        req.getSession().setAttribute("lastName",cartItem.getName());

    }
    /*
    * 删除商品项
    * */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //获取购物车对象

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            //删除了购物车商品项
            cart.deleteItem(id);
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    /*
    * 清空购物车
    * */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            //清空购物车
            cart.clear();
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    /*
    * 修改商品数量
    * */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，商品编号，商品数量
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count =WebUtils.parseInt(req.getParameter("count"),1);
        //获取cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart!=null){
            //修改商品数量
            cart.updateCount(id,count);
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /*
     * 加入购物车
     * */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        // 调用bookService.queryBookById:Book得到图书信息
        Book book = bookService.queryBookById(id);
        // 把图书信息，转化为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        // 调用Cart.addItem(CartItem) 添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);

        //最后一个添加商品的名称
        req.getSession().setAttribute("lastName",cartItem.getName());

        //6 返回购物车商品数量和最后一个添加的商品名称
        Map<String,Object> resultMap = new HashMap<String,Object>();

        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);
        resp.getWriter().write(resultMapJsonString);

    }
}
