package com.cy.test;

import com.cy.pojo.Cart;
import com.cy.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"云边有个小卖部",1,new BigDecimal(60),new BigDecimal(60)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"云边有个小卖部",1,new BigDecimal(60),new BigDecimal(60)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"云边有个小卖部",1,new BigDecimal(60),new BigDecimal(60)));

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"云边有个小卖部",1,new BigDecimal(60),new BigDecimal(60)));

        cart.clear();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100)));
        cart.updateCount(1,10);
        System.out.println(cart);
    }
}