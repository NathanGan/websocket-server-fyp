package com.service;

import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.service.MongoDBService;
import com.util.MongoDbUtil;
import org.bson.Document;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nathan on 2017/12/31.
 */
public class MongoDBServiceImpl implements MongoDBService {
    private MongoCollection<Document> mongoCollection;
    public MongoDBServiceImpl(String type){
        if(type.equals("restaurants")){
            mongoCollection = MongoDbUtil.instance.getMongoCollection("test","restaurants");
        }
        if(type.equals("users")){
            mongoCollection = MongoDbUtil.instance.getMongoCollection("test","user");
        }
        if(type.equals("orders'")){
            mongoCollection = MongoDbUtil.instance.getMongoCollection("test","orders");
        }
    }
    public MongoCollection<Document> getMongoCollection(){
        return mongoCollection;
    }
    public Document getDocumentByID(int id) {
        return MongoDbUtil.instance.findById(mongoCollection, id);
    }
    public Document getDocumentByName(String name) {
        return MongoDbUtil.instance.findByName(mongoCollection, name);
    }
    public Document getDocumentByTag(String name, String value) {
        return MongoDbUtil.instance.findByTag(mongoCollection, name, value);
    }
    public MongoCursor<Document> getDocumentsByTags(ArrayList<String> constrains) {
        return MongoDbUtil.instance.findByTags(mongoCollection, constrains);
    }
    public void updateDocument(int uid,JSONArray location){
        MongoDbUtil.instance.updateDocument(mongoCollection,uid,location);
    }
}
