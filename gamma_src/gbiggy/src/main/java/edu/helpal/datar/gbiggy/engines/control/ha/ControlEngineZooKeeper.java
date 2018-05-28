package edu.helpal.datar.gbiggy.engines.control.ha;

import edu.helpal.datar.gbiggy.framework.cores.ControlWrapper;
import edu.helpal.datar.gbiggy.framework.cores.IEngine;

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
