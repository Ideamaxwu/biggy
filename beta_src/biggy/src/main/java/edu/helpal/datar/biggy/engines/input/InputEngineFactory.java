package edu.helpal.datar.biggy.engines.input;

import edu.helpal.datar.biggy.engines.input.AsterixDBFeed.InputEngineADBFeed;
import edu.helpal.datar.biggy.engines.input.Flafka.InputEngineFlafka;

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
