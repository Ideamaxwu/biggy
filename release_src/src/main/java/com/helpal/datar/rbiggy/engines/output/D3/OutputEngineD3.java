package com.helpal.datar.rbiggy.engines.output.D3;

import com.helpal.datar.rbiggy.engines.output.IOutputEngine;

/**
 * 
 * OutputEngine D3
 *
 */
public class OutputEngineD3 implements IOutputEngine{
	private String engineName = "BDIO";
	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup OutputEngine as D3.");
	}
	@Override
	public String getEngineName() {
		return engineName;
	}
}
