package com.helpal.datar.rbiggy.engines.control.locking;

/**
 * 
 * ChubbyEngine
 *
 */
public class ChubbyEngine {
	String moduleName; 
	public void run(){
		moduleName = "Chubby Engine module";
		System.out.println(moduleName + " starting...");
		//start engine
		runJob();
		System.out.println(moduleName + " running...");
	}
	
	void runJob(){
		new ChubbyJob().run();
	}

}
