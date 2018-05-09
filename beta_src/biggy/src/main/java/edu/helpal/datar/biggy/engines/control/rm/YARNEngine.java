package edu.helpal.datar.biggy.engines.control.rm;

import edu.helpal.datar.biggy.engines.control.rm.YARNJob;

/**
 * 
 * YARNEngine
 *
 */
public class YARNEngine {
	String moduleName; 
	public void run(){
		moduleName = "YARN Engine module";
		System.out.println(moduleName + " starting...");
		//start engine
		runJob();
		System.out.println(moduleName + " running...");
	}
	
	void runJob(){
		new YARNJob().run();
	}

}
