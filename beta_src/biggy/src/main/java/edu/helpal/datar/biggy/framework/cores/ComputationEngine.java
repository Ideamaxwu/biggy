package edu.helpal.datar.biggy.framework.cores;

/**
 * Computation Engine
 *
 */
 public class ComputationEngine implements Engine{
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