package edu.helpal.datar.biggy.engines.storage;

import edu.helpal.datar.biggy.framework.cores.IEngine;
import edu.helpal.datar.biggy.framework.cores.StorageWrapper;

/**
 * Storage Engine HBase
 *
 */
 public class StorageEngineHBase extends StorageWrapper{
	 private String engineName = "HBase";
	 
	 public StorageEngineHBase(IEngine storageEngine){
		 super(storageEngine);
	 }
	 
	 @Override
	 public void start(){
		 storageEngine.start();
		 setStorageEngine(storageEngine);
		 runEngine();
	 }
	 
	 private void setStorageEngine(IEngine storageEngine){
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