package com.cy.dao.impl;

import com.cy.dao.OrderDao;
import com.cy.pojo.Order;

public class OrderImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {

        System.out.println("OrderImpl程序在【" + Thread.currentThread().getName() + "】中");

        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
