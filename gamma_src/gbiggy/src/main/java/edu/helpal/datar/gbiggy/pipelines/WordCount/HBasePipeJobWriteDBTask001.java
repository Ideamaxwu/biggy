package edu.helpal.datar.gbiggy.pipelines.WordCount;

import java.util.Map;
import java.util.Map.Entry;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class HBasePipeJobWriteDBTask001 {

	public void flush(Map<Long, String> content, String tableName) {
		String dbName = "ExamplesDB";
        String collName = tableName;
        MongoDBDriver.instance.dropCollection(dbName, collName);
        MongoCollection<Document> coll = MongoDBDriver.instance.getCollection(dbName, collName);
        
		for (Entry<Long, String> entry : content.entrySet()){
			//System.out.println("Tuple inserted to HBase["+ tableName +"]: "+ entry.getValue());
			//tuple insert
			Document doc = new Document();
			doc.put("item", entry.getValue());
			coll.insertOne(doc);
		}
		
		//lookup collection
		/*
		MongoCursor<Document> cursor = MongoDBDriver.instance.find(coll);
		System.out.println("Tuples in Table[" + collName + "]:");
		while(cursor.hasNext()){
			Document d = cursor.next();
			System.out.println(d.toString());
		}
		*/
		MongoDBDriver.instance.close();
		
	}
}
