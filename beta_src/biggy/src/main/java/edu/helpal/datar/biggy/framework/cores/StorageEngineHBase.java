package edu.helpal.datar.biggy.framework.cores;

import edu.helpal.datar.biggy.engines.storage.HBaseEngine;

/**
 * Storage Engine HBase
 *
 */
 public class StorageEngineHBase extends StorageWrapper{
	 private String engineName = "HBase";
	 
	 public StorageEngineHBase(Engine storageEngine){
		 super(storageEngine);
	 }
	 
	 @Override
	 public void start(){
		 storageEngine.start();
		 setStorageEngine(storageEngine);
		 runEngine();
	 }
	 
	 private void setStorageEngine(Engine storageEngine){
		 System.out.println("Add Storage Engine: HBase.");
	 }
	 
	 private void runEngine(){
		 HBaseEngine hbasengn = new HBaseEngine();
		 hbasengn.run();
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return storageEngine.getInfo() + ": " + getEngineName();
	 }
 }