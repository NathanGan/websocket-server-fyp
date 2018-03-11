package com.service;

import com.dao.OrdersMapper;
import com.dao.UserMapper;
import com.model.User;
import com.model.UserExample;
import com.util.JsonUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory factory ;
    SqlSession sqlSession;
    UserMapper userMapper;

    public UserServiceImpl(String type) throws IOException {
        if(type.equals("mysql")){
            try{
                inputStream=Resources.getResourceAsStream(resource);
                builder = new SqlSessionFactoryBuilder();
                factory = builder.build(inputStream);
                sqlSession = factory.openSession(true);
                userMapper = sqlSession.getMapper(UserMapper.class);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(type.equals("mongo")){

        }
    }


    public UserServiceImpl() throws IOException {

    }

    /**
     * sign up operation
     * @param user
     * @return
     */
    public int signupUser(User user) {
        try{
            UserExample newUser = new UserExample();
            newUser.createCriteria().andNameEqualTo(user.getName()).andTypeEqualTo(user.getType());

            if((int)userMapper.countByExample(newUser)==0){
                return userMapper.insert(user);
            }else{
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * sign in operation
     * @param user
     * @return
     */
    public int signinUser(User user) {
        try{
            UserExample signin = new UserExample();
            signin.createCriteria().andNameEqualTo(user.getName()).andPasswordEqualTo(user.getPassword());
            return userMapper.selectByExample(signin).get(0).getId();
        }catch (Exception e){
            return -1;
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

    /**
     * get other user by name
     * @param name
     * @return
     */
    public User getUserByName(String name) {
        try {
            UserExample getUser = new UserExample();
            getUser.createCriteria().andNameEqualTo(name);
            return userMapper.selectByExample(getUser).get(0);
        }catch (Exception e){
            return null;
        }
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

    /**
     * get user's friends list, find in redis cache first, then mongoDB
     * @param user
     * @return
     */
    public ArrayList<User> getFriends(User user) {

        return null;
    }

    /**
     * add a new friend into mongodb, then cache in redis.
     * @param userID
     * @return
     */
    public int addFriend(int userID) {
        return 0;
    }

    public ArrayList<User> getAllSharers(ArrayList<String> sharers) {

        return null;
    }
}
