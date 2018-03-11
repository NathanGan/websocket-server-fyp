package com.controller;

import com.model.Orders;
import com.model.User;
import com.service.OrderService;
import com.service.UserService;
import com.service.OrderServiceImpl;
import com.service.UserServiceImpl;
import com.util.StatusCode;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/6.
 */
public class OrderController{

    private JSONObject requestParams;
    private JSONObject responseParams = new JSONObject();
    public OrderController(JSONObject requestParams){
        this.requestParams = requestParams;
    }

    public JSONObject actionGetHistoryOrders() throws IOException {

        String name = requestParams.getString("name");
        String password = requestParams.getString("password");
        String type = requestParams.getString("type");
        User user = new User(name,password);
        UserService userService = new UserServiceImpl();
        OrderService orderService = null;
        try {
            orderService = new OrderServiceImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Orders> orders = null;
//        if(userService.verifyUser(user)==true){
//            if(type.equals("shared"))
//                orders = orderService.searchSharedRecords(user);
//            if(type.equals("shareto"))
//                orders = orderService.searchShareToRecords(user);
//        }else{
//        }
        JSONObject responseParams = new JSONObject();
        responseParams.put("orders",orders);
        return responseParams;
    }

    /**
     * the method for finding all qualified restaurants and calling the
     * qualified sharers inside with the requester's info.
     */
    public JSONObject actionCallAnOrder() {
        String name = requestParams.getString("name");

        StatusCode statusCode = null;
        return responseParams;

    }

    /**
     *
     */
    public JSONObject actionAnswerAnOrder(){
        String name = requestParams.getString("name");
        return responseParams;
    }


    public JSONObject actionTerminateAnOrder() throws IOException {
        String username = requestParams.getString("username");
        String password = requestParams.getString("password");
        User user = new User(username, password);
        UserService userService = new UserServiceImpl();

        StatusCode statusCode = null;
//        if(userService.verifyUser(user)==true){
//            statusCode = new StatusCode(1, null);
//        }else{
//            statusCode = new StatusCode(0, null);
//        }
        return responseParams;
    }

    public JSONObject actionSendMessage(){
        String name = requestParams.getString("name");
        String password = requestParams.getString("password");
        String type = requestParams.getString("type");
        String message = requestParams.getString("message");

        return responseParams;
    }

    public JSONObject actionFinishAnOrder(){
        String username = requestParams.getString("username");
        String password  = requestParams.getString("password");
        String order = requestParams.getString("order");

        return responseParams;
    }

    public JSONObject actionAddCommentToOrder(){
        String username = requestParams.getString("username");
        String password = requestParams.getString("password");
        String comment = requestParams.getString("comment");
        String order = requestParams.getString("order");

        return responseParams;
    }

}
