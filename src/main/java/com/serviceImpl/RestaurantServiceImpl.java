package com.serviceImpl;

import com.dao.RestaurantMapper;
import com.dao.UserMapper;
import com.model.Restaurant;
import com.service.MongoDBService;
import com.service.RestaurantService;
import com.util.TransFactory;
import com.util.TransFactoryM2O;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bson.Document;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/6.
 */
public class RestaurantServiceImpl implements RestaurantService {

    String resource = "com/mapper/MapperConfiguration.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(inputStream);
    SqlSession sqlSession = factory.openSession();
    RestaurantMapper restaurantMapper = sqlSession.getMapper(RestaurantMapper.class);

    public MongoDBService mongoDBService;
    public TransFactory transFactory;
    public RestaurantServiceImpl() throws IOException{
        mongoDBService = new MongoDBServiceImpl("restaurants");
        transFactory = new TransFactoryM2O();
    }

    public int addNewComment(String comment) {
        return 0;
    }

    public int addNewTag(String tag) {
        return 0;
    }

    public Restaurant searchRestaurantByName(String name) {
        Restaurant restaurant = (Restaurant) transFactory.translate(
                mongoDBService.getDocumentByName(name),"Restaurant");
        return restaurant;
    }

    public ArrayList<Restaurant> getNearByRestaurants(int distance, int num) {
        return null;
    }

    public ArrayList<Restaurant> getRestaurantsByTag(ArrayList<String> constrains) {
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) transFactory.translate(
                mongoDBService.getDocumentsByTags(constrains),"Restaurants");
        return restaurants;
    }

    public ArrayList<Restaurant> getViewHistory(String username) {
        return null;
    }

    public ArrayList<String> getSharersInRestaurant(ArrayList<Restaurant> restaurants) {
        if(restaurants==null){
            return null;
        }else{
            ArrayList<String> allSharers = new ArrayList<String>();
            for(Restaurant restaurant:restaurants){
                ArrayList<String> sharers = restaurant.getShare_ids();
                for(String sharer:sharers){
                    allSharers.add(sharer);
                }
            }
            return allSharers;
        }
    }

    public ArrayList<Restaurant> getRecommendRestaurants(String username) {
        return null;
    }
}
