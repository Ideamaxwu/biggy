package edu.helpal.datar.biggy.engines.computation;

/* SparkExample */
import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;

public class SparkExample {
	private JavaSparkContext sc;

	public void run() {
		System.out.println("/*******this is an Spark example******/");
		String logFile = "src/main/resources/config/DBcount.txt"; 
		SparkConf conf = new SparkConf().setAppName("SparkExample").setMaster("local");
		sc = new JavaSparkContext(conf);
		JavaRDD<String> logData = sc.textFile(logFile).cache();

		long numDBs = logData.filter(s -> s.contains("DB")).count();

		System.out.println("Lines with DB: " + numDBs);
		System.out.println("/*******this is the end of the Spark example******/");
	}
}