package com.cy.test;

import com.cy.dao.OrderDao;
import com.cy.dao.impl.OrderImpl;
import com.cy.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderImpl();
        orderDao.saveOrder(new Order("123",new Date(),new BigDecimal(100),0,1));
    }
}