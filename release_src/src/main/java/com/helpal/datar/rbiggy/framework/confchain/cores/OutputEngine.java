package com.helpal.datar.rbiggy.framework.confchain.cores;

/**
 * 
 * Output Engine
 *
 */
 public class OutputEngine implements IEngine{
	 private String engineType = "OutputEngine";

	 public void start(){
		 System.out.println("Output Engine Initializing...");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 public String getInfo(){
		 return getEngineType();
	 };
 }