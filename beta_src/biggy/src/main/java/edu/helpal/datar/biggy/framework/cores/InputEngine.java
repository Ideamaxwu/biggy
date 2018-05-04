package edu.helpal.datar.biggy.framework.cores;

/**
 * Input Engine
 *
 */
 public class InputEngine implements Engine{
	 private String engineType = "InputEngine";

	 public void start(){
		 System.out.println("Input Engine Initializing.");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 public String getInfo(){
		 return getEngineType();
	 };
 }