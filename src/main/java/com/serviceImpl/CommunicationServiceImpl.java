package com.serviceImpl;

import com.service.CommunicationService;
import com.service.MongoDBService;
import com.service.UserService;

import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/16.
 */
public class CommunicationServiceImpl implements CommunicationService {
    public void sendMsgToUser() {

    }

    public void sendSignalToUser() {

    }

    public void notifyAllNearBySharer(ArrayList<String> sharers) {

    }

    public void notifyAllNearByRequester() {

    }

    public void notifyAllSharers(ArrayList<String> sharers) {
        UserService userService = new UserServiceImpl();
    }

}
