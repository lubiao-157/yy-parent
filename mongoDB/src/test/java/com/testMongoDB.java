package com;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

public class testMongoDB {

    @Test
    public void test1(){
        //MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoClientURI c = new MongoClientURI("mongodb://root:root@local:27017");
        MongoClient mongoClient = new MongoClient(c);
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> collection = database.getCollection("startup_log");
        Document myDoc = collection.find().first();
        String json = myDoc.toJson();

        System.out.println(json);
    }
}
