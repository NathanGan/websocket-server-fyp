package com.service;

import com.dao.RestaurantMapper;
import com.dao.UserMapper;
import com.dao.UserRestaurantHistoryMapper;
import com.model.Restaurant;
import com.model.RestaurantExample;
import com.model.UserRestaurantHistory;
import com.model.UserRestaurantHistoryExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathan on 2018/3/11.
 */
public class RestaurantServiceImpl implements RestaurantService
{
    String resource = "com/mapper/MapperConfiguration.xml";
    InputStream inputStream;
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory factory ;
    SqlSession sqlSession;
    RestaurantMapper restaurantMapper;
    UserRestaurantHistoryMapper userRestaurantHistoryMapper;
    public RestaurantServiceImpl(String type){
        if(type.equals("mysql")){
            try{
                inputStream= Resources.getResourceAsStream(resource);
                builder = new SqlSessionFactoryBuilder();
                factory = builder.build(inputStream);
                sqlSession = factory.openSession(true);
                restaurantMapper = sqlSession.getMapper(RestaurantMapper.class);
                userRestaurantHistoryMapper = sqlSession.getMapper(UserRestaurantHistoryMapper.class);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(type.equals("mongodb")){

        }
    }

    /**
     * add new comment to restaurant and record in MongoDB
     * @param comment
     * @return
     */
    @Override
    public int addNewComment(String comment) {
        return 0;
    }

    /**
     * <deprecated>
     * @param tag
     * @return
     */
    @Override
    public int addNewTag(String tag) {
        return 0;
    }

    /**
     * search the restaurant with name and return its basic information from MySQL
     * @param name
     * @return
     */
    @Override
    public Restaurant searchRestaurantByName(String name) {
        RestaurantExample restaurantExample = new RestaurantExample();
        restaurantExample.createCriteria().andNameEqualTo(name);
        return restaurantMapper.selectByExample(restaurantExample).get(0);
    }

    /**
     * search the nearby restaurants from MongoDB
     * @param distance
     * @param num
     * @return
     */
    @Override
    public ArrayList<Restaurant> getNearByRestaurants(int distance, int num) {
        return null;
    }

    /**
     * search the restaurants with tags from MongoDB
     * @param constrains
     * @return
     */
    @Override
    public ArrayList<Restaurant> getRestaurantsByTag(ArrayList<String> constrains) {
        return null;
    }

    /**
     * get the recommendation result from Redis
     * @param username
     * @return
     */
    @Override
    public ArrayList<Restaurant> getRecommendRestaurants(String username) {
        return null;
    }

    /**
     * get all the restaurant id from Table UserRestaurantHistory, then
     * give back their name from Table Restaurant
     * @param uid
     * @return
     */
    @Override
    public ArrayList<Restaurant> getViewHistory(int uid) {
        UserRestaurantHistoryExample viewHistory = new UserRestaurantHistoryExample();
        viewHistory.createCriteria().andUidEqualTo(uid);
        List<UserRestaurantHistory> viewList = userRestaurantHistoryMapper.selectByExample(viewHistory);
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        for(UserRestaurantHistory record:viewList){
            restaurants.add(restaurantMapper.selectByPrimaryKey(record.getRid()));
        }
        return restaurants;
    }

    /**
     * get all the sharer in Restaurant from MongoDB
     * @param restaurants
     * @return
     */
    @Override
    public ArrayList<String> getSharersInRestaurant(ArrayList<Restaurant> restaurants) {
        return null;
    }
}
