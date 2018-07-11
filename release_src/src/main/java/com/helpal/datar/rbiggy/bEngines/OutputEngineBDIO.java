package com.helpal.datar.rbiggy.bEngines;

import com.helpal.datar.rbiggy.engines.output.IOutputEngine;

/**
 * 
 * OutputEngine BDIO
 *
 */
public class OutputEngineBDIO implements IOutputEngine{
	private String engineName = "BDIO";
	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup OutputEngine as bEngine BDIO.");
	}
	@Override
	public String getEngineName() {
		return engineName;
	}
}
