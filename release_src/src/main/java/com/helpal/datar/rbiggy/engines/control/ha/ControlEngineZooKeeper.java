package com.helpal.datar.rbiggy.engines.control.ha;

import com.helpal.datar.rbiggy.framework.cores.ControlWrapper;
import com.helpal.datar.rbiggy.framework.cores.IEngine;

/**
 * 
 * Control Engine ZooKeeper
 *
 */
public class ControlEngineZooKeeper extends ControlWrapper{
	private String engineName = "Zookeeper";
	 
	 public ControlEngineZooKeeper(IEngine controlEngine){
		 super(controlEngine);
	 }
	 
	 @Override
	 public void start(){
		 controlEngine.start();
		 setControlEngine(controlEngine);
		 runEngine();
	 }
	 
	 private void setControlEngine(IEngine controlEngine){
		 System.out.println("Add Control Engine: ZooKeeper.");
	 }
	 
	 private void runEngine(){
		 ZooKeeperEngine ZKngn = new ZooKeeperEngine();
		 ZKngn.run();
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return controlEngine.getInfo() + ": " + getEngineName();
	 }

}
