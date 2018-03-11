package com.service;

import com.dao.OrdersMapper;
import com.dao.UserMapper;
import com.model.Orders;
import com.model.User;
import com.service.OrderService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/5.
 */
public class OrderServiceImpl implements OrderService {

    String resource = "com/mapper/MapperConfiguration.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(inputStream);
    SqlSession sqlSession = factory.openSession();
    OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

    public OrderServiceImpl() throws IOException{

    }

    public int createNewOrder(Orders orders) {
        try{
            ordersMapper.insert(orders);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public int completeOrder(Orders orders) {
        try{
            ordersMapper.updateByPrimaryKey(orders);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public int interruptOrder(Orders orders) {
        try{
            ordersMapper.updateByPrimaryKey(orders);
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public int updateOrderInfo(Orders orders) {
        try{
            ordersMapper.updateByPrimaryKey(orders);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public ArrayList<Orders> searchShareToRecords(User user) {
        ArrayList<Orders> orderList = null;
        try{
            orderList = (ArrayList<Orders>) ordersMapper.selectByExample(null);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return orderList;
    }

    public ArrayList<Orders> searchSharedRecords(User user) {
        ArrayList<Orders> orderList = null;
        try {
            orderList = (ArrayList<Orders>) ordersMapper.selectByExample(null);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return orderList;
    }

}
