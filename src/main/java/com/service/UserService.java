package com.service;


import com.model.User;

import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/4.
 */
public interface UserService {


    public int signupUser(User user);
    public int signinUser(User user);
    public int updateUserSession(User user);
    public int signoffUser(User user);
    public int updateUser(User user);
    public String getUserSessionId(String name);
    public User getUserByName(String name);
    public User getUserByID(int uid);
    public ArrayList<User> getFriends(User user);
    public int addFriend(int userID);

    public ArrayList<User> getAllSharers(ArrayList<String> sharers);
}
