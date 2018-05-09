package edu.helpal.datar.biggy.engines.computation;

/**
 * SparkStandaloneJob Example
 *
 */

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;

public class SparkStandaloneJob {
	private JavaSparkContext jsc;

	public void run() {
		System.out.println("/*******this is an SparkStandaloneJob example******/");
		final String logFile = "src/main/resources/config/DBcount.txt"; 
		SparkConf conf = new SparkConf().setAppName("SparkJobExample").setMaster("local");
		jsc = new JavaSparkContext(conf);
		JavaRDD<String> logData = jsc.textFile(logFile).cache();

		long numDBs = logData.filter(s -> s.contains("DB")).count();

		jsc.stop();
		
		System.out.println("Lines with DB: " + numDBs);
		System.out.println("/*******this is the end of the SparkStandaloneJob example******/");
	}
}