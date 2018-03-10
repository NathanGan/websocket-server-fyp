package com.service;

import java.util.ArrayList;

/**
 * Created by nathan on 2017/11/16.
 */
public interface CommunicationService {

    public void sendMsgToUser();
    public void sendSignalToUser();
    public void notifyAllNearBySharer(ArrayList<String> sharers);
    public void notifyAllNearByRequester();
    public void notifyAllSharers(ArrayList<String> sharers);
}
