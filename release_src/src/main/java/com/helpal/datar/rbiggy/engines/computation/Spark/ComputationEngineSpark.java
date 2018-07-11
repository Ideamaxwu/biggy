package com.helpal.datar.rbiggy.engines.computation.Spark;

import com.helpal.datar.rbiggy.engines.computation.IComputationEngine;

/**
 * 
 * ComputationEngine Spark
 *
 */
public class ComputationEngineSpark implements IComputationEngine{
	private String engineName = "Spark";
	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup ComputationEngine as Spark.");
	}
	@Override
	public String getEngineName() {
		return engineName;
	}

}
