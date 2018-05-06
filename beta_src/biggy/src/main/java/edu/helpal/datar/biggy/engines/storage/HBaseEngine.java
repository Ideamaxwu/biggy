package edu.helpal.datar.biggy.engines.storage;

/**
 * HBase Engine
 *
 */

public class HBaseEngine
{
	String moduleName; 
	public void run(){
		moduleName = "HBase Engine module";
		System.out.println(moduleName + " starting...");
		//start engine
		runJob();
		System.out.println(moduleName + " running...");
	}
	
	void runJob(){
		new HBaseJob().run();
	}
	
}