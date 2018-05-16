package edu.helpal.datar.biggy.engines.control.ha;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;

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
		try {
			new ZKJob().run();
		} catch (IOException | InterruptedException | KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
