package edu.helpal.datar.gbiggy.engines.control.rm;

import edu.helpal.datar.gbiggy.framework.cores.ControlWrapper;
import edu.helpal.datar.gbiggy.framework.cores.IEngine;

/**
 * Control Engine YARN
 *
 */
 public class ControlEngineYARN extends ControlWrapper{
	 private String engineName = "YARN";
	 
	 public ControlEngineYARN(IEngine controlEngine){
		 super(controlEngine);
	 }
	 
	 @Override
	 public void start(){
		 controlEngine.start();
		 setControlEngine(controlEngine);
		 runEngine();
	 }
	 
	 private void setControlEngine(IEngine controlEngine){
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