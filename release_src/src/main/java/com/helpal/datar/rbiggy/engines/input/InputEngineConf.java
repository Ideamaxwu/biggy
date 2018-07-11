package com.helpal.datar.rbiggy.engines.input;

import com.helpal.datar.rbiggy.framework.confchain.cores.IEngine;
import com.helpal.datar.rbiggy.framework.confchain.cores.InputWrapper;

/**
 * 
 * Input Engine Conf
 *
 */
 public class InputEngineConf extends InputWrapper{
	 private String engineName = "Default bEngine BDIO";
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
		 System.out.println("Add Input Engine: " + inputEngine.getEngineName() + ".");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return inputEngine.getInfo() + ": " + getEngineName();
	 }
 }