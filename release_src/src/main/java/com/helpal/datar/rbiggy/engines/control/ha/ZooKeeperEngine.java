package com.helpal.datar.rbiggy.engines.control.ha;

/**
 * 
 * ZooKeeperEnine
 *
 */
public class ZooKeeperEngine {
	String moduleName; 
	public void run(){
		moduleName = "ZooKeeper Engine module";
		System.out.println(moduleName + " starting...");
		//start engine
		runJob();
		System.out.println(moduleName + " running...");
	}
	void runJob(){
		new ZKJob().run();
	}
}
