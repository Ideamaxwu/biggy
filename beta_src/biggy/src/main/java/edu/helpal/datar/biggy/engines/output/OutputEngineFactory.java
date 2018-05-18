package edu.helpal.datar.biggy.engines.output;

import edu.helpal.datar.biggy.engines.output.D3.OutputEngineD3;

/**
 * 
 * OutputEngine Factory
 *
 */
public class OutputEngineFactory {
	public IOutputEngine getOutputEngine(String engineName){
		if(engineName == null){
			return null;
		}
		
		if(engineName.equalsIgnoreCase("D3")){
			return new OutputEngineD3();
		}
		
		return null;
	}
}
