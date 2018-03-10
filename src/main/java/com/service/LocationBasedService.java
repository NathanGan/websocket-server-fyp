package com.service;

import com.model.Location;
import com.model.User;

/**
 * Created by nathan on 2017/11/14.
 */
public interface LocationBasedService {

    public void recordUserLoginLocation(User user, Location location);
    public void updateUserLocation(User user, Location location);
    public void findNearBySharer();
    public void findNearByRequester();
    public void findNearByRestaurants(User user, int distance);

}
