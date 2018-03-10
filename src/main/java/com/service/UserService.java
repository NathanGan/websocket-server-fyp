package com.service;


import com.model.User;

import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/4.
 */
public interface UserService {


    public boolean createUser(User user);
    public boolean verifyUser(User user);
    public int signoffUser(User user);
    public int updateUser(User user);
    public User getUserByName(String name);
    public User getUserByID(int uid);
    public ArrayList<User> getFriends(User user);
    public int addFriend(int userID);

    public ArrayList<User> getAllSharers(ArrayList<String> sharers);
}