package com.helpal.datar.rbiggy.pipelines.utils;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * 
 * MongoDB Driver
 *
 */
public enum MongoDBDriver {
	
	//enum instance
	instance;

	private static MongoClient mongoClient;

	static {
		System.out.println("MongoDBUtil initializing...");
		String ip = "localhost";
		int port = 27017;
		MongoDBDriver.mongoClient = new MongoClient(ip, port);
		Builder options = new MongoClientOptions.Builder();
		options.cursorFinalizerEnabled(true);
		options.connectionsPerHost(300);
		options.connectTimeout(30000);
		options.maxWaitTime(5000); //
		options.socketTimeout(0);
		options.threadsAllowedToBlockForConnectionMultiplier(5000);
		options.build();
	}

	public MongoDatabase getDB(String dbName) {
		if (dbName != null && !"".equals(dbName)) {
			MongoDatabase database = mongoClient.getDatabase(dbName);
			return database;
		}
		return null;
	}


	public MongoCollection<Document> getCollection(String dbName, String collName) {
		if (null == collName || "".equals(collName)) {
			return null;
		}
		if (null == dbName || "".equals(dbName)) {
			return null;
		}
		MongoCollection<Document> collection = mongoClient.getDatabase(dbName).getCollection(collName);
		return collection;
	}

	public MongoCursor<Document> find(MongoCollection<Document> coll) {
		return coll.find().iterator();
	}

	public void dropCollection(String dbName, String collName) {
		getDB(dbName).getCollection(collName).drop();
	}

	public void dropDB(String dbName) {
		getDB(dbName).drop();
	}

	public void close() {
		if (mongoClient != null) {
			mongoClient.close();
			mongoClient = null;
		}
	}
}
