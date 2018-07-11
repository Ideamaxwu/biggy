package com.helpal.datar.rbiggy.engines.input;

import com.helpal.datar.rbiggy.bEngines.InputEngineBDIO;
import com.helpal.datar.rbiggy.engines.input.AsterixDBFeed.InputEngineADBFeed;
import com.helpal.datar.rbiggy.engines.input.Flafka.InputEngineFlafka;

/**
 * 
 * InputEngine Factory
 *
 */
public class InputEngineFactory {
	public IInputEngine getInputEngine(String engineName){
		
		switch(engineName){
		case "Flafka":
			return new InputEngineFlafka();
		case "ADBFeed":
			return new InputEngineADBFeed();
		default:
			System.out.println("NO customized InputEngine or UNAVAILABLE customized InputEngine as " + engineName +"!");
			return new InputEngineBDIO();
		}
	}
}
