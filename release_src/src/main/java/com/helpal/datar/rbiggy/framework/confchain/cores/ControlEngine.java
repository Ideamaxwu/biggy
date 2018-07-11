package com.helpal.datar.rbiggy.framework.confchain.cores;

/**
 * 
 * Control Engine
 *
 */
 public class ControlEngine implements IEngine{
	 private String engineType = "ControlEngine";

	 public void start(){
		 System.out.println("Control Engine Initializing...");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 public String getInfo(){
		 return getEngineType();
	 };
 }