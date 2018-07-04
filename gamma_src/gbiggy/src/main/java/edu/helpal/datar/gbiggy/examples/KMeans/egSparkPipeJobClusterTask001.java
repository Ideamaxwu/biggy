package edu.helpal.datar.gbiggy.examples.KMeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.clustering.KMeans;
import org.apache.spark.mllib.clustering.KMeansModel;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;

public class egSparkPipeJobClusterTask001 {
	private JavaSparkContext jsc;
	private static final Pattern COMMA = Pattern.compile(",");
	public Map<Long, String> run(Map<Long, String> content){
		System.out.println("/***   Spark WordCount Task   ***/");
		
		SparkConf conf = new SparkConf().setAppName("SparkJob").setMaster("local");
		jsc = new JavaSparkContext(conf);
		
		Map<Long, String> result = new HashMap<Long, String>();
		
		//convert Map to List
		List<String> dataList = new ArrayList<String>();
		for (Entry<Long, String> entry : content.entrySet()){
			dataList.add(entry.getValue());
		}
		
		JavaRDD<String> data = jsc.parallelize(dataList);//convert List to RDD
		JavaRDD<Vector> parsedData = data.map(s -> {
	        double[] values = Arrays.asList(COMMA.split(s))
	              .stream()
	              .mapToDouble(Double::parseDouble)
	              .toArray();
	        return Vectors.dense(values);
	    });
		
		int numClusters = 4;
		//int numClusters = 100;
		int numIterations = 20;
		int runTimes = 3;
		KMeansModel clusters = KMeans.train(parsedData.rdd(), numClusters, numIterations, runTimes);
		
		//System.out.println(parsedData.map(p -> p.toString() + " belong to cluster: " + clusters.predict(p)).collect());
		for (String s : parsedData.map(p -> p.toString() + " -> " + clusters.predict(p)).collect()){
			//System.out.println(s);
			String[] kv = s.split(" -> ");
			long v = Long.parseLong(kv[1]);
			String k = kv[0];
			if(result.containsKey(v)){
				result.put(v, result.get(v)+" "+k);
			}else{
				result.put(v, k);
			}
		}
		
		double wssse = clusters.computeCost(parsedData.rdd());
	    System.out.println("Within Set Sum of Squared Errors = " + wssse);
	    /*
	    System.out.println("Cluster centers:");
	    for (Vector center : clusters.clusterCenters()) {
	        System.out.println(" " + center);
	    }
	    */
	    jsc.stop();
	    
	    content = result;
	    
		return content;
	}
}
