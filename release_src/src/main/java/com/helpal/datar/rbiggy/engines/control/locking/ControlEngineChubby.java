package com.helpal.datar.rbiggy.engines.control.locking;

import com.helpal.datar.rbiggy.framework.confchain.cores.ControlWrapper;
import com.helpal.datar.rbiggy.framework.confchain.cores.IEngine;

/**
 * 
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