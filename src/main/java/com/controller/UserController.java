package com.controller;

import com.model.User;
import com.service.MongoDBService;
import com.service.UserService;
import com.service.MongoDBServiceImpl;
import com.service.UserServiceImpl;
import com.util.StatusCode;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by nathan on 2017/11/4.
 */
@Controller
public class UserController {

    private UserService userService;

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
    public JSONObject actionNewSignUp() throws IOException {
        // Parse request data
        String name = requestParams.getString("username");
        String password = requestParams.getString("password");
        String type = requestParams.getString("userType");
        User user = new User(name,password,type);
        userService = new UserServiceImpl("mysql");
        int uid = userService.signupUser(user);
        if(uid!=-1){
            responseParams.put("uid",uid);
            responseParams.put("responseType","SIGNUP_SUCCESS");
        }
        else{
            responseParams.put("uid",-1);
            responseParams.put("responseType","SIGNUP_FAIL");
        }
        // send data back to client
        return responseParams;
    }

    /**
     * login with a existing user account
     * MySQL
     * @throws Exception
     */
    public JSONObject actionSignIn(String sessionid){
        String name = requestParams.getString("username");
        String password = requestParams.getString("password");
        String type = requestParams.getString("userType");
        User user = new User(name,password,type,sessionid);
        UserService userService = null;
        try {
            userService = new UserServiceImpl("mysql");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int uid = userService.signinUser(user);
        if(uid!=-1){
            responseParams.put("uid",uid);
            responseParams.put("responseType","SIGNIN_SUCCESS");
        }
        else{
            responseParams.put("uid",-1);
            responseParams.put("responseType","SIGNIN_FAIL");
        }
        // send data back to client
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
    public JSONObject actionAddFriend() throws IOException {
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
        int uid = requestParams.getInt("uid");
        JSONArray location = requestParams.getJSONArray("location");
        MongoDBService mongoDBService = new MongoDBServiceImpl("users");
        mongoDBService.updateDocument(uid,location);
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

    /**
     * The method for get user's session id from MySQL by username
     * @return session id
     */
    public String actionGetUserSession(){
        System.out.println("actionGetUserSession");
        try{
            userService = new UserServiceImpl("mysql");
            return userService.getUserSessionId(requestParams.getString("tname"));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
