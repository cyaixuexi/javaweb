package com.cy.service;

import com.cy.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
