package edu.helpal.datar.gbiggy.pipelines.WordCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkPipeJobWordCountTask001 {
	private JavaSparkContext jsc;
	public Map<Long, String> run(Map<Long, String> content){
		System.out.println("/***   SparkCount TEST Task   ***/");
		Map<Long, String> result = new HashMap<Long, String>();
		result.put((long) -1, "SparkCountTest");
		
		//convert Map to List
		List<String> dataList = new ArrayList<String>();
		for (Entry<Long, String> entry : content.entrySet()){
			dataList.add(entry.getValue());
		}
		
		//Spark working
		final String logFile = "src\\main\\java\\edu\\helpal\\datar\\gbiggy\\pipelines\\WordCount\\data\\DBcount_DB.txt"; 
		SparkConf conf = new SparkConf().setAppName("SparkJobExample").setMaster("local");
		jsc = new JavaSparkContext(conf);
		JavaRDD<String> logData = jsc.textFile(logFile).cache();
		JavaRDD<String> data = jsc.parallelize(dataList);//convert List to RDD
		long numDBs = logData.filter(s -> s.contains("DB")).count();
		JavaPairRDD<String, Integer> datardd = data.mapToPair(t -> new Tuple2<String, Integer>(t, 1)).reduceByKey((x,y) -> x+y);//mad and reduce
		
		System.out.println("Lines with DB: " + numDBs);
		//Spark work end
		
		long id = 0;
		for (Tuple2<String, Integer> entry : datardd.collect()) {
			System.out.println(entry._1 + ": " + entry._2);
			result.put(id, entry._1 + ": " + (long) entry._2);
			id += 1;
		}
		
		jsc.stop();
		
		result.put((long) -2, "Lines with DB: " + numDBs);
		content = result;
		return content;
	}
}
