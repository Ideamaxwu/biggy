package com.helpal.datar.rbiggy.engines.storage;

import com.helpal.datar.rbiggy.engines.storage.HBase.StorageEngineHBase;

/**
 * 
 * StorageEngine Factory
 *
 */
public class StorageEngineFactory {
	public IStorageEngine getStorageEngine(String engineName){
		if(engineName == null){
			return null;
		}
		
		if(engineName.equalsIgnoreCase("HBase")){
			return new StorageEngineHBase();
		}
		
		return null;
	}
}
