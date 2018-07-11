package com.helpal.datar.rbiggy.engines.storage;

import com.helpal.datar.rbiggy.bEngines.StorageEngineOracle;
import com.helpal.datar.rbiggy.engines.storage.HBase.StorageEngineHBase;

/**
 * 
 * StorageEngine Factory
 *
 */
public class StorageEngineFactory {
	public IStorageEngine getStorageEngine(String engineName){
		switch(engineName){
		case "HBase":
			return new StorageEngineHBase();
		default:
			System.out.println("NO customized StorageEngine or UNAVAILABLE customized StorageEngine as " + engineName +"!");
			return new StorageEngineOracle();
		}
	}
}
