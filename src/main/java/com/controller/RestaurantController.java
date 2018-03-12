package com.controller;

import com.model.Restaurant;
import com.service.RestaurantService;
import com.util.StatusCode;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/6.
 */
public class RestaurantController {

    private JSONObject requestParams;
    private JSONObject responseParams = new JSONObject();
    public RestaurantController(JSONObject requestParams){
        this.requestParams = requestParams;
    }
    public JSONObject actionSearchRestaurantByName(){
        String name = requestParams.getString("name");
        // create new object for dao and response
        StatusCode statusCode = null;
        RestaurantService restaurantService = null;
//        try {
//            restaurantService = new RestaurantServiceImpl();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Restaurant restaurant = restaurantService.searchRestaurantByName(name);
        return responseParams;
    }
    public JSONObject actionSearchRestaurantByTags(){
        String[] tags = (String[])requestParams.get("values");
        ArrayList<String> constrains = new ArrayList<String>();
        for(String tag:tags){
            constrains.add(tag);
        }
        RestaurantService restaurantService = null;
//        try {
//            restaurantService = new RestaurantServiceImpl();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ArrayList<Restaurant> restaurants = restaurantService.getRestaurantsByTag(constrains);
        return responseParams;
    }
    public JSONObject actionSearchRestaurantByDistance(){
        int distance = requestParams.getInt("distance");
        RestaurantService restaurantService = null;
//        try {
//            restaurantService = new RestaurantServiceImpl();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ArrayList<Restaurant> restaurants = restaurantService.getNearByRestaurants(distance,10);
        return responseParams;
    }
    public JSONObject actionGetRecommendedRestaurants(){
        String username = requestParams.getString("username");
        RestaurantService restaurantService = null;
//        try {
//            restaurantService = new RestaurantServiceImpl();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ArrayList<Restaurant> restaurants = restaurantService.getRecommendRestaurants(username);
        return responseParams;
    }
    public JSONObject actionGetHistoryRestaurants(){
        String username = requestParams.getString("username");
        RestaurantService restaurantService = null;
//        try {
//            restaurantService = new RestaurantServiceImpl();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ArrayList<Restaurant> restaurants = restaurantService.getViewHistory(username);
        return responseParams;
    }
    public JSONObject actionAssignRestaurant(){
        String username = requestParams.getString("username");
        String restaurant = requestParams.getString("restaurant");
        RestaurantService restaurantService = null;
//        try{
//            restaurantService = new RestaurantServiceImpl();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        return responseParams;
    }
}
