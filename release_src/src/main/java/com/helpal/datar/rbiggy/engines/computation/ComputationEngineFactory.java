package com.helpal.datar.rbiggy.engines.computation;

import com.helpal.datar.rbiggy.bEngines.ComputationEngineAbacus;
import com.helpal.datar.rbiggy.engines.computation.Spark.ComputationEngineSpark;

/**
 * 
 * ComputationEngine Factory
 *
 */
public class ComputationEngineFactory {
	public IComputationEngine getComputationEngine(String engineName){
		switch(engineName.toLowerCase()){
		case "Spark":
			return new ComputationEngineSpark();
		default:
			System.out.println("NO customized ComputationEngine or UNAVAILABLE customized ComputationEngine!");
			return new ComputationEngineAbacus();
		}
	}
}
