package edu.helpal.datar.gbiggy.framework.cores;

/**
 * Computation Engine
 *
 */
 public class ComputationEngine implements IEngine{
	 private String engineType = "ComputationEngine";
	 
	 public void start(){
		 System.out.println("Computation Engine Initializing.");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 public String getInfo(){
		 return getEngineType();
	 };
 }