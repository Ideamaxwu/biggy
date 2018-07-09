package com.helpal.datar.rbiggy.framework.cores;

/**
 * 
 * Input Engine
 *
 */
 public class InputEngine implements IEngine{
	 private String engineType = "InputEngine";

	 public void start(){
		 System.out.println("Input Engine Initializing...");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 public String getInfo(){
		 return getEngineType();
	 };
 }