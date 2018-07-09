package com.helpal.datar.rbiggy.engines.output;

import com.helpal.datar.rbiggy.framework.cores.IEngine;
import com.helpal.datar.rbiggy.framework.cores.OutputWrapper;

/**
 * 
 * Output Engine Conf
 *
 */
 public class OutputEngineConf extends OutputWrapper{
	 private String engineName = "Default XXX";
	 private OutputEngineFactory outputEngineFactory = new OutputEngineFactory(); 
	 
	 public OutputEngineConf(IEngine outputEngine, String confEngineName){
		 super(outputEngine);
		 if (confEngineName != null){
			engineName = confEngineName; 
		 }
	 }
	 
	 @Override
	 public void start(){
		 outputEngine.start();
		 setOutputEngine();
	 }
	 
	 private void setOutputEngine(){
		 IOutputEngine outputEngine = outputEngineFactory.getOutputEngine(engineName);
		 outputEngine.setup();
		 System.out.println("Add Output Engine: " + engineName + ".");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return outputEngine.getInfo() + ": " + getEngineName();
	 }
 }