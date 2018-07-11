package com.helpal.datar.rbiggy.bEngines;

import com.helpal.datar.rbiggy.engines.computation.IComputationEngine;

/**
 * 
 * ComputationEngine Abacus
 *
 */
public class ComputationEngineAbacus implements IComputationEngine{
	private String engineName = "Abacus";
	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup ComputationEngine as bEngine Abacus.");
	}
	@Override
	public String getEngineName() {
		return engineName;
	}

}
