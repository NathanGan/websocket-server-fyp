package com.serviceImpl;

import com.dao.UserMapper;
import com.model.User;
import com.service.RedisService;
import com.service.UserService;
import com.util.JsonUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by nathan on 2017/11/5.
 */
public class UserServiceImpl implements UserService {

    String resource = "com/mapper/MapperConfiguration.xml";
    InputStream inputStream;
    SqlSession sqlSession;
    UserMapper userMapper;
    public UserServiceImpl(String type){
        if(type.equals("mysql")){
            try {
                inputStream = Resources.getResourceAsStream(resource);
                SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
                SqlSessionFactory factory = builder.build(inputStream);
                sqlSession = factory.openSession();
                userMapper = sqlSession.getMapper(UserMapper.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(type.equals("mongo")){

        }
    }

    public UserServiceImpl() {

    }

    public boolean createUser(User user) {
        try{
            userMapper.insert(user);
            sqlSession.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyUser(User user) {
        try{
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public int signoffUser(User user) {
        try{
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    public int updateUser(User user) {
        try{
            return 1;
        }catch (Exception e){
            return 0;
        }
    }


    public User getUserByName(String name) {
        return null;
    }

    public User getUserByID(int uid) {
        RedisService redisService = new RedisServiceImpl();
        String json = redisService.get(uid+"");
        if(json==null){
            User userInfo = userMapper.selectByPrimaryKey(uid);
            if(userInfo!=null){
                redisService.put(uid+"", userInfo, 1, TimeUnit.HOURS);
            }
            return userInfo;
        }

        return JsonUtils.fromJson(json, User.class);
    }

    public ArrayList<User> getFriends(User user) {
        return null;
    }

    public int addFriend(int userID) {
        return 0;
    }

    public ArrayList<User> getAllSharers(ArrayList<String> sharers) {

        return null;
    }
}
