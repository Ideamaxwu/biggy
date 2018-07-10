package com.helpal.datar.rbiggy.engines.output;

import com.helpal.datar.rbiggy.bEngines.OutputEngineBDIO;
import com.helpal.datar.rbiggy.engines.output.D3.OutputEngineD3;

/**
 * 
 * OutputEngine Factory
 *
 */
public class OutputEngineFactory {
	public IOutputEngine getOutputEngine(String engineName){
		switch(engineName.toLowerCase()){
		case "D3":
			return new OutputEngineD3();
		default:
			System.out.println("NO customized OutputEngine or UNAVAILABLE customized OutputEngine!");
			return new OutputEngineBDIO();
		}
	}
}
