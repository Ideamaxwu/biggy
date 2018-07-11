package com.helpal.datar.rbiggy.bEngines;

import com.helpal.datar.rbiggy.engines.storage.IStorageEngine;

/**
 * 
 * StoregeEngine Oracle
 *
 */
public class StorageEngineOracle implements IStorageEngine{
	private String engineName = "Oralce";
	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup StorageEngine as bEngine Oracle.");
	}
	@Override
	public String getEngineName() {
		return engineName;
	}

}
