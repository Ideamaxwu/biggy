package com.helpal.datar.rbiggy.engines.input;

import com.helpal.datar.rbiggy.engines.input.AsterixDBFeed.InputEngineADBFeed;
import com.helpal.datar.rbiggy.engines.input.Flafka.InputEngineFlafka;

/**
 * 
 * InputEngine Factory
 *
 */
public class InputEngineFactory {
	public IInputEngine getInputEngine(String engineName){
		if(engineName == null){
			return null;
		}
		
		if(engineName.equalsIgnoreCase("Flafka")){
			return new InputEngineFlafka();
		}
		
		if(engineName.equalsIgnoreCase("ADBFeed")){
			return new InputEngineADBFeed();
		}
		
		return null;
	}
}
