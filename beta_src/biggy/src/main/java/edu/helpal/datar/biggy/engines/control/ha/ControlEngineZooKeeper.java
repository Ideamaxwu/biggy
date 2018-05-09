package edu.helpal.datar.biggy.engines.control.ha;

import edu.helpal.datar.biggy.framework.cores.ControlWrapper;
import edu.helpal.datar.biggy.framework.cores.Engine;

/**
 * 
 * Control Engine ZooKeeper
 *
 */
public class ControlEngineZooKeeper extends ControlWrapper{
	private String engineName = "YARN";
	 
	 public ControlEngineZooKeeper(Engine controlEngine){
		 super(controlEngine);
	 }
	 
	 @Override
	 public void start(){
		 controlEngine.start();
		 setControlEngine(controlEngine);
		 runEngine();
	 }
	 
	 private void setControlEngine(Engine controlEngine){
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
