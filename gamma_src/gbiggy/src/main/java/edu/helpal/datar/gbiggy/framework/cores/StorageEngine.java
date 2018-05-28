package edu.helpal.datar.gbiggy.framework.cores;

/**
 * Storage Engine
 *
 */
 public class StorageEngine implements IEngine{
	 private String engineType = "StorageEngine";

	 public void start(){
		 System.out.println("Storage Engine Initializing.");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 public String getInfo(){
		 return getEngineType();
	 };
 }