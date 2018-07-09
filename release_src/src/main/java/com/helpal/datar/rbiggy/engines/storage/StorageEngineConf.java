package com.helpal.datar.rbiggy.engines.storage;

import com.helpal.datar.rbiggy.framework.cores.IEngine;
import com.helpal.datar.rbiggy.framework.cores.StorageWrapper;

/**
 * 
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