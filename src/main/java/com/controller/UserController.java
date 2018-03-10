package com.controller;

import com.dao.UserMapper;
import com.model.Location;
import com.model.User;
import com.service.LocationBasedService;
import com.service.MongoDBService;
import com.service.UserService;
import com.serviceImpl.LocationBasedServiceImpl;
import com.serviceImpl.MongoDBServiceImpl;
import com.serviceImpl.UserServiceImpl;
import com.util.JSONUtil;
import com.util.StatusCode;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/4.
 */
public class UserController {

    private JSONObject requestParams;
    private JSONObject responseParams = new JSONObject();
    public UserController(JSONObject requestParams){
        this.requestParams = requestParams;
    }

    /**
     * create a new account for app
     * MySQL
     * @throws Exception
     */
    public JSONObject actionNewSignUp(){
        // Parse request data
        String name = requestParams.getString("name");
        String password = requestParams.getString("password");
        User user = new User(null,name,password,null,null,false,1);
        StatusCode statusCode = null;
        UserService userService = new UserServiceImpl();
        if(userService.createUser(user)==true){
            responseParams.put("responseType","signupSuc");
        }
        else{
            responseParams.put("responseType","signupFail");
        }
        // send data back to client
        return responseParams;
    }

    /**
     * login with a existing user account
     * MySQL
     * @throws Exception
     */
    public JSONObject actionSignIn(){
        String name = requestParams.getString("name");
        String password = requestParams.getString("password");
        User user = new User(name,password);
        UserService userService = new UserServiceImpl("mysql");
        if(userService.verifyUser(user)==true){
            responseParams.put("responseType","loginSuc");
        }else{
            responseParams.put("responseType","loginFail");
        }
        return responseParams;
    }

    /**
     * get friends based on user account
     * MySQL
     */
    public JSONObject actionGetFriends(){
        String name = requestParams.getString("name");
        String password = requestParams.getString("password");
        System.out.println("actionGetFriends");
        return responseParams;
    }

    /**
     * MySQL
     */
    public JSONObject actionAddFriend(){
        String name = requestParams.getString("name");
        UserService userService = new UserServiceImpl();
        System.out.println("actionAddFriend");
        return responseParams;
    }

    /**
     * The method for updating user's location to show on the
     * map both sharer and requester sides.
     * MongoDB
     */
    public JSONObject actionUpdateLocation(){
        String name = requestParams.getString("name");
        MongoDBService mongoDBService = new MongoDBServiceImpl("users");
        System.out.println("actionUpdateLocation");

        return responseParams;
    }
    /**
     * The Method for copying friend's taste and get similar recommendation
     */
    public JSONObject actionCopyTaste(){
        String name = requestParams.getString("name");
        System.out.println("actionCopyTaste");
        return responseParams;
    }
    /**
     * The method for changing sharer's share status (on/off)
     */
    public JSONObject actionChangeStatus(){
        String name = requestParams.getString("name");
        System.out.println("actionChangeStatus");
        return responseParams;
    }
}
