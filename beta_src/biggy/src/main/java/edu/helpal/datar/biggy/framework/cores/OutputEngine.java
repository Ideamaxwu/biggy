package edu.helpal.datar.biggy.framework.cores;

/**
 * Output Engine
 *
 */
 public class OutputEngine implements Engine{
	 private String engineType = "OutputEngine";

	 public void start(){
		 System.out.println("Output Engine Initializing.");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 public String getInfo(){
		 return getEngineType();
	 };
 }