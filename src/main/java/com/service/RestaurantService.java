package com.service;


import com.model.Restaurant;

import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/6.
 */
public interface RestaurantService {
    public int addNewComment(String comment);
    public int addNewTag(String tag);
    public Restaurant searchRestaurantByName(String name);
    public ArrayList<Restaurant> getNearByRestaurants(int distance, int num);
    public ArrayList<Restaurant> getRestaurantsByTag(ArrayList<String> constrains);
    public ArrayList<Restaurant> getRecommendRestaurants(String username);
    public ArrayList<Restaurant> getViewHistory(String username);
    public ArrayList<String> getSharersInRestaurant(ArrayList<Restaurant> restaurants);

}
