package com.helpal.datar.rbiggy.engines.computation;

import com.helpal.datar.rbiggy.engines.computation.Spark.ComputationEngineSpark;

/**
 * 
 * ComputationEngine Factory
 *
 */
public class ComputationEngineFactory {
	public IComputationEngine getComputationEngine(String engineName){
		if(engineName == null){
			return null;
		}
		
		if(engineName.equalsIgnoreCase("Spark")){
			return new ComputationEngineSpark();
		}
		
		return null;
	}
}
