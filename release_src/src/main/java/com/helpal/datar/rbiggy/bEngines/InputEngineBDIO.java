package com.helpal.datar.rbiggy.bEngines;

import com.helpal.datar.rbiggy.engines.input.IInputEngine;

/**
 * 
 * InputEngine BDIO
 *
 */
public class InputEngineBDIO implements IInputEngine{
	private String engineName = "BDIO";
	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup InputEngine as bEngine BDIO.");
	}

	@Override
	public String getEngineName() {
		return engineName;
	}

}
