package edu.helpal.datar.biggy.framework.cores;

/**
 * Control Engine
 *
 */
 public class ControlEngine implements Engine{
	 private String engineType = "ControlEngine";

	 public void start(){
		 System.out.println("Control Engine Initializing.");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 public String getInfo(){
		 return getEngineType();
	 };
 }