package edu.helpal.datar.gbiggy.engines.storage;

import edu.helpal.datar.gbiggy.framework.cores.IEngine;
import edu.helpal.datar.gbiggy.framework.cores.StorageWrapper;

/**
 * Storage Engine Conf
 *
 */
 public class StorageEngineConf extends StorageWrapper{
	 private String engineName = "Default XXX";
	 private StorageEngineFactory storageEngineFactory = new StorageEngineFactory(); 
	 
	 public StorageEngineConf(IEngine storageEngine, String confEngineName){
		 super(storageEngine);
		 if (confEngineName != null){
			engineName = confEngineName; 
		 }
	 }
	 
	 @Override
	 public void start(){
		 storageEngine.start();
		 setStorageEngine();
	 }
	 
	 private void setStorageEngine(){
		 IStorageEngine storageEngine = storageEngineFactory.getStorageEngine(engineName);
		 storageEngine.setup();
		 System.out.println("Add Storage Engine: " + engineName + ".");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return storageEngine.getInfo() + ": " + getEngineName();
	 }
 }