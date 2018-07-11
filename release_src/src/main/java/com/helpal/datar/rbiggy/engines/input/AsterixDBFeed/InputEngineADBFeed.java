package com.helpal.datar.rbiggy.engines.input.AsterixDBFeed;

import com.helpal.datar.rbiggy.engines.input.IInputEngine;

/**
 * 
 * InputEngine AsterixDB Feed
 *
 */
public class InputEngineADBFeed implements IInputEngine{
	private String engineName = "ADBFeed";
	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup InputEngine as AsterixDB Feed.");
	}

	@Override
	public String getEngineName() {
		return engineName;
	}
}
