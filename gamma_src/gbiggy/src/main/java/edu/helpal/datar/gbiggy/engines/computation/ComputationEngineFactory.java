package edu.helpal.datar.gbiggy.engines.computation;

import edu.helpal.datar.gbiggy.engines.computation.Spark.ComputationEngineSpark;

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
