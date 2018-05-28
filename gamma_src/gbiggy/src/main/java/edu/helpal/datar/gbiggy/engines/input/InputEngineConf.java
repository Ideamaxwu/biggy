package edu.helpal.datar.gbiggy.engines.input;

import edu.helpal.datar.gbiggy.framework.cores.IEngine;
import edu.helpal.datar.gbiggy.framework.cores.InputWrapper;

/**
 * Input Engine Conf
 *
 */
 public class InputEngineConf extends InputWrapper{
	 private String engineName = "Default XXX";
	 private InputEngineFactory inputEngineFactory = new InputEngineFactory(); 
	 
	 public InputEngineConf(IEngine inputEngine, String confEngineName){
		 super(inputEngine);
		 if (confEngineName != null){
			engineName = confEngineName; 
		 }
	 }
	 
	 @Override
	 public void start(){
		 inputEngine.start();
		 setInputEngine();
	 }
	 
	 private void setInputEngine(){
		 IInputEngine inputEngine = inputEngineFactory.getInputEngine(engineName);
		 inputEngine.setup();
		 System.out.println("Add Input Engine: " + engineName + ".");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return inputEngine.getInfo() + ": " + getEngineName();
	 }
 }