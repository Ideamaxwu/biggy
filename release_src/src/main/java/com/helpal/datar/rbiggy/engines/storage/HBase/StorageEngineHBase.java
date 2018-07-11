package com.helpal.datar.rbiggy.engines.storage.HBase;

import com.helpal.datar.rbiggy.engines.storage.IStorageEngine;

/**
 * 
 * StoregeEngine HBase
 *
 */
public class StorageEngineHBase implements IStorageEngine{
	private String engineName = "HBase";
	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup StorageEngine as HBase.");
	}

	@Override
	public String getEngineName() {
		return engineName;
	}
}
