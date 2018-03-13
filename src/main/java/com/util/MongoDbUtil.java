package com.util;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.json.JSONArray;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nathan on 2017/11/14.
 */
public enum MongoDbUtil {
    instance;
    private MongoClient mongoClient;
    static {
        System.out.println("initializing.....");

        // connection configuration
        String host = "127.0.0.1";
        int port = 27017;

        //create new mongo client instance
        instance.mongoClient = new MongoClient(host,port);
        //if create in cluster mode,
        //List<ServerAddress> listHost = Arrays.asList(new ServerAddress(host,port), new ServerAddress(host,port));
        //instance.mongoClient = new MongoClient(listHost);
        MongoClientOptions.Builder options = new MongoClientOptions.Builder();
        options.connectionsPerHost(300);
        options.connectTimeout(15000);
        options.maxWaitTime(5000);
        options.socketTimeout(0);
        options.threadsAllowedToBlockForConnectionMultiplier(5000);
        options.writeConcern(WriteConcern.ACKNOWLEDGED);
        options.build();
    }
    public MongoDatabase getMongoDb(String dbName){
        if(dbName!=null&&!"".equals(dbName)){
            MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
            return mongoDatabase;
        }
        return null;
    }
    public MongoCollection<Document> getMongoCollection(String dbName, String collName){
        if(dbName==null && dbName.equals("")){
            return null;
        }
        if(collName==null && collName.equals("")){
            return null;
        }
        MongoCollection<Document> mongoCollection = mongoClient.getDatabase(dbName).getCollection(collName);
        return mongoCollection;
    }

    /**
     * find document by id
     * @param collection
     * @param id
     * @return
     */
    public Document findById(MongoCollection<Document> collection, int id){
        Document document = collection.find(Filters.eq("_uid",id)).first();
        return document;
    }

    /**
     *
     * @param collection
     * @param name
     * @return
     */
    public Document findByName(MongoCollection<Document> collection, String name){
        Document document = collection.find(Filters.eq("_name",name)).first();
        return document;
    }

    public Document findByTag(MongoCollection<Document> collection, String tag, String value){
        Document document = collection.find(Filters.eq(tag, value)).first();
        return document;
    }

    /**
     *
     * @param collection
     * @param values
     * @return
     */
    public MongoCursor<Document> findByTags(MongoCollection<Document> collection, Iterable<String> values){
        Bson filter = Filters.all("tag", values);
        return collection.find(filter).iterator();
    }

    /**
     * find document by filter and paging result
     * @param coll
     * @param filter
     * @param pageNo
     * @param pageSize
     * @return
     */
    public MongoCursor<Document> findByPage(MongoCollection<Document> coll, Bson filter, int pageNo, int pageSize){
        return coll.find(filter).skip((pageNo - 1) * pageSize).limit(pageSize).iterator();
    }

    public void updateDocument(MongoCollection<Document> collection, int uid, JSONArray location){
        try{
            Bson newValue = new Document("location",location);
            Bson updateDocumentOperation = new Document("$set",newValue);
            System.out.println(collection.updateOne(Filters.eq("_uid",uid),updateDocumentOperation));
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    /**
     * close mongoclient connection
     */
    public void closeClientConn(){
        if(mongoClient != null){
            mongoClient.close();
            mongoClient = null;
        }
        System.out.println("closed");
    }

}
