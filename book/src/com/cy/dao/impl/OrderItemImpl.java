package com.cy.dao.impl;

import com.cy.dao.OrderItemDao;
import com.cy.pojo.OrderItem;

public class OrderItemImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem ordetItem) {

        System.out.println("OrderItemImpl程序在【" + Thread.currentThread().getName() + "】中");

        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";

        return update(sql,ordetItem.getName(),ordetItem.getCount(),ordetItem.getPrice(),ordetItem.getTotalPrice(),ordetItem.getOrderId());
    }
}
