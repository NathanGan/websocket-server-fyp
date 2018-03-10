package com.model;

/**
 * Created by nathan on 2017/11/15.
 */
public class Location {

    private double longitude, latitude;
    public Location(){

    }
    public Location(double lon, double lat){
        this.longitude = lon;
        this.latitude = lat;
    }

    public double getLongitude(){
        return longitude;
    }
    public double getLatitude(){
        return latitude;
    }
}
