package edu.helpal.datar.gbiggy.examples.KMeans;

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

public class egSparkPipeJobClusterTask001 {
	private JavaSparkContext jsc;
	public Map<Long, String> run(Map<Long, String> content){
		System.out.println("/***   Spark WordCount Task   ***/");
		
		/*
		Map<Long, String> result = new HashMap<Long, String>();
		
		//convert Map to List
		List<String> dataList = new ArrayList<String>();
		for (Entry<Long, String> entry : content.entrySet()){
			dataList.add(entry.getValue());
		}
		
		//Spark working
		SparkConf conf = new SparkConf().setAppName("SparkJob").setMaster("local");
		jsc = new JavaSparkContext(conf);
		JavaRDD<String> data = jsc.parallelize(dataList);//convert List to RDD
		JavaPairRDD<String, Integer> datardd = data.mapToPair(t -> new Tuple2<String, Integer>(t, 1)).reduceByKey((x,y) -> x+y);//mad and reduce
		//Spark work end
		
		long id = 0;
		for (Tuple2<String, Integer> entry : datardd.collect()) {
			System.out.println(entry._1 + ": " + entry._2);
			result.put(id, entry._1 + ": " + (long) entry._2);
			id += 1;
		}
		
		jsc.stop();
		
		content = result;
		
		*/
		
		return content;
	}
}
