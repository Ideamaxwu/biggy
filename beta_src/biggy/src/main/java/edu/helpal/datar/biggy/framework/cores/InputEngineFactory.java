package edu.helpal.datar.biggy.framework.cores;

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
