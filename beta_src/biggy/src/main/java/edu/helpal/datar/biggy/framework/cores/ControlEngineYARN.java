package edu.helpal.datar.biggy.framework.cores;

import edu.helpal.datar.biggy.engines.control.YARNEngine;

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
		 runEngine();
	 }
	 
	 private void setControlEngine(Engine controlEngine){
		 System.out.println("Add Control Engine: YARN.");
	 }
	 
	 private void runEngine(){
		 YARNEngine YARNngn = new YARNEngine();
		 YARNngn.run();
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return controlEngine.getInfo() + ": " + getEngineName();
	 }
 }