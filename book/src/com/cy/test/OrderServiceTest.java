package com.cy.test;

import com.cy.pojo.Cart;
import com.cy.pojo.CartItem;
import com.cy.pojo.OrderItem;
import com.cy.service.OrderService;
import com.cy.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"云边有个小卖部",1,new BigDecimal(60),new BigDecimal(60)));

        OrderService orderService  = new OrderServiceImpl();
        System.out.println("订单号是:"+orderService.createOrder(cart, 1));
    }
}