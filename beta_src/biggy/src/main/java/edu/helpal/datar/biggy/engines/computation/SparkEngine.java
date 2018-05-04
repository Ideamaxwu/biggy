package edu.helpal.datar.biggy.engines.computation;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

/**
 * Spark Engine
 *
 */

public class SparkEngine
{
	String moduleName; 
	public void run(){
		moduleName = "Spark Engine module";
		System.out.println(moduleName + " starting...");
		//start engine
		runExample();
		System.out.println(moduleName + " running...");
	}
	
	void runExample(){
		new SparkExample().run();
	}
}