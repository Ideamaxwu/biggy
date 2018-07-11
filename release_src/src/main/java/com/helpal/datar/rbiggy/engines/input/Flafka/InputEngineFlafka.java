package com.helpal.datar.rbiggy.engines.input.Flafka;

import com.helpal.datar.rbiggy.engines.input.IInputEngine;

/**
 * 
 * InputEngine Flafka
 *
 */
public class InputEngineFlafka implements IInputEngine{
	private String engineName = "Flafka";
	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup InputEngine as Flafka.");
	}

	@Override
	public String getEngineName() {
		return engineName;
	}
}
