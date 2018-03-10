package com.util;

import com.model.Location;
import com.model.Restaurant;
import com.model.User;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;

/**
 * Created by nathan on 2018/1/1.
 */
public class TransFactoryM2O implements TransFactory {

    public Object translate(Object obj, String type) {


        if (type.equals("Restaurant")){
            Document document = (Document) obj;
            int uid = document.getInteger("_uid");
            String name = document.getString("_name");
            int share_num = document.getInteger("sharer_num");
            ArrayList<String> share_ids = (ArrayList<String>) document.get("sharer_ids");
            ArrayList<Double> resLocation = (ArrayList<Double>) document.get("location");
            Location location = new Location(resLocation.get(0), resLocation.get(1));
            ArrayList<String> tags = (ArrayList<String>) document.get("tags");
            Restaurant restaurant = new Restaurant(uid,name,share_num,share_ids,location,tags);
            return restaurant;
        }
        if (type.equals("Restaurants")){
            MongoCursor<Document> documents = (MongoCursor<Document>) obj;
            ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
            while(documents.hasNext()){
                Document document = documents.next();
                int uid = document.getInteger("_uid");
                String name = document.getString("_name");
                int share_num = document.getInteger("sharer_num");
                ArrayList<String> share_ids = (ArrayList<String>) document.get("sharer_ids");
                ArrayList<Double> resLocation = (ArrayList<Double>) document.get("location");
                Location location = new Location(resLocation.get(0), resLocation.get(1));
                ArrayList<String> tags = (ArrayList<String>) document.get("tags");
                Restaurant restaurant = new Restaurant(uid,name,share_num,share_ids,location,tags);
                restaurants.add(restaurant);
            }
            return restaurants;
        }
        if (type.equals("User")){
            Document document = (Document) obj;
            int id = document.getInteger("_uid");
            String name = document.getString("_name");
            String userType = document.getString("type");
            int share_time = document.getInteger("share_time", -1);
            int vacancy = document.getInteger("vacancy", -1);
            ArrayList<Double> userLocation = (ArrayList<Double>) document.get("location");
            Location location = new Location(userLocation.get(0), userLocation.get(1));
            User user = new User(id,name,userType,share_time,vacancy,location);
            return user;
        }
        else{
            return null;
        }
    }
}
