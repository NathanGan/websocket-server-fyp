package com.service;

import com.model.Orders;
import com.model.User;

/**
 * Created by nathan on 2017/11/8.
 */
public interface KafkaProducerService {

    public void produceLocation(User user);
    public void produceOrder(Orders orders, User user);
    public void produceUserInfo(User user);

}
