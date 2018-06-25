package edu.helpal.datar.gbiggy.pipelines.WordCount;

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
	/**
	 * 定义一个枚举的元素，它代表此类的一个实例
	 */
	instance;

	private static MongoClient mongoClient;

	static {
		System.out.println("===============MongoDBUtil初始化========================");
		String ip = "localhost";
		int port = 27017;
		MongoDBDriver.mongoClient = new MongoClient(ip, port);
		Builder options = new MongoClientOptions.Builder();
		options.cursorFinalizerEnabled(true);
		options.connectionsPerHost(300);// 连接池设置为300个连接,默认为100
		options.connectTimeout(30000);// 连接超时，推荐>3000毫秒
		options.maxWaitTime(5000); //
		options.socketTimeout(0);// 套接字超时时间，0无限制
		options.threadsAllowedToBlockForConnectionMultiplier(5000);// 线程队列数，如果连接线程排满了队列就会抛出“Out
																	// of
																	// semaphores
																	// to get
																	// db”错误。
		options.build();
	}

	// ------------------------------------共用方法---------------------------------------------------
	/**
	 * 获取DB实例 - 指定DB
	 * 
	 * @param dbName
	 * @return
	 */
	public MongoDatabase getDB(String dbName) {
		if (dbName != null && !"".equals(dbName)) {
			MongoDatabase database = mongoClient.getDatabase(dbName);
			return database;
		}
		return null;
	}

	/**
	 * 获取collection对象 - 指定Collection
	 * 
	 * @param collName
	 * @return
	 */
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

	/** 
	 * 表查询 
	 */
	public MongoCursor<Document> find(MongoCollection<Document> coll) {
		return coll.find().iterator();
	}

	/**
	 * 删除一个表
	 */
	public void dropCollection(String dbName, String collName) {
		getDB(dbName).getCollection(collName).drop();
	}

	/**
	 * 删除一个数据库
	 */
	public void dropDB(String dbName) {
		getDB(dbName).drop();
	}

	/**
	 * 关闭Mongodb
	 */
	public void close() {
		if (mongoClient != null) {
			mongoClient.close();
			mongoClient = null;
		}
	}
}
