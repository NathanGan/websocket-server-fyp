package com.service;

import com.model.Orders;
import com.model.User;

import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/5.
 */
public interface OrderService {

    public int createNewOrder(Orders orders);
    public int completeOrder(Orders orders);
    public int interruptOrder(Orders orders);
    public int updateOrderInfo(Orders orders);
    public ArrayList<Orders> searchShareToRecords(User user);
    public ArrayList<Orders> searchSharedRecords(User user);
}
