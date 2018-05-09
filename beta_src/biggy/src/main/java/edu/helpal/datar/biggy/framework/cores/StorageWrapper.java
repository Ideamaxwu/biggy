package edu.helpal.datar.biggy.framework.cores;

/**
 * Storage Wrapper
 *
 */
 public abstract class StorageWrapper implements IEngine{
	 protected IEngine storageEngine;
	 
	 public StorageWrapper(IEngine storageEngine){
		 this.storageEngine = storageEngine;
	 }
	 
	 public void start(){
		 storageEngine.start();
	 }
 }