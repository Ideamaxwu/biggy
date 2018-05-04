package edu.helpal.datar.biggy.framework.cores;

/**
 * Storage Engine HBase
 *
 */
 public class ControlEngineYARN extends ControlWrapper{
	 private String engineName = "YARN";
	 
	 public ControlEngineYARN(Engine controlEngine){
		 super(controlEngine);
	 }
	 
	 @Override
	 public void start(){
		 controlEngine.start();
		 setControlEngine(controlEngine);
	 }
	 
	 private void setControlEngine(Engine controlEngine){
		 System.out.println("Add Control Engine: YARN.");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return controlEngine.getInfo() + ": " + getEngineName();
	 }
 }