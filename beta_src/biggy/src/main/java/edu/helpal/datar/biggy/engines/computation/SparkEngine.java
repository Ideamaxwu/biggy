package edu.helpal.datar.biggy.engines.computation;

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
		runJob();
		System.out.println(moduleName + " running...");
	}
	
	void runJob(){
		new SparkStandaloneJob().run();
		new SparkClusterJob().run();
	}
}