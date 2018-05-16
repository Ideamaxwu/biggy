package edu.helpal.datar.biggy.engines.control.locking;

import edu.helpal.datar.biggy.framework.cores.ControlWrapper;
import edu.helpal.datar.biggy.framework.cores.IEngine;

/**
 * Control Engine Chubby
 *
 */
 public class ControlEngineChubby extends ControlWrapper{
	 private String engineName = "Chubby";
	 
	 public ControlEngineChubby(IEngine controlEngine){
		 super(controlEngine);
	 }
	 
	 @Override
	 public void start(){
		 controlEngine.start();
		 setControlEngine(controlEngine);
		 runEngine();
	 }
	 
	 private void setControlEngine(IEngine controlEngine){
		 System.out.println("Add Control Engine: Chubby.");
	 }
	 
	 private void runEngine(){
		 ChubbyEngine Chubbyngn = new ChubbyEngine();
		 Chubbyngn.run();
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return controlEngine.getInfo() + ": " + getEngineName();
	 }
 }