package com.service;

import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nathan on 2017/12/31.
 */
public interface MongoDBService {

    public Document getDocumentByID(int id);
    public Document getDocumentByName(String name);
    public Document getDocumentByTag(String name, String value);
    public MongoCursor<Document> getDocumentsByTags(ArrayList<String> constrains);

}
