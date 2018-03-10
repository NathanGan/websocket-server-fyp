package com.serviceImpl;

import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.service.MongoDBService;
import com.util.MongoDbUtil;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nathan on 2017/12/31.
 */
public class MongoDBServiceImpl implements MongoDBService {
    private MongoCollection<Document> mongoCollection;
    private MongoDbUtil mongoDbUtil;
    public MongoDBServiceImpl(String type){
        mongoDbUtil = MongoDbUtil.instance;
        if(type.equals("restaurants")){
            mongoCollection = mongoDbUtil.getMongoCollection("ShareT","restaurants");
        }
        if(type.equals("users")){
            mongoCollection = mongoDbUtil.getMongoCollection("ShareT","users");
        }
        if(type.equals("orders'")){
            mongoCollection = mongoDbUtil.getMongoCollection("ShareT","orders");
        }
    }
    public MongoCollection<Document> getMongoCollection(){
        return mongoCollection;
    }
    public Document getDocumentByID(int id) {
        return mongoDbUtil.findById(mongoCollection, id);
    }
    public Document getDocumentByName(String name) {
        return mongoDbUtil.findByName(mongoCollection, name);
    }
    public Document getDocumentByTag(String name, String value) {
        return mongoDbUtil.findByTag(mongoCollection, name, value);
    }
    public MongoCursor<Document> getDocumentsByTags(ArrayList<String> constrains) {
        return mongoDbUtil.findByTags(mongoCollection, constrains);
    }
}
