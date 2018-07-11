package com.helpal.datar.rbiggy.engines.output;

import com.helpal.datar.rbiggy.framework.confchain.cores.IEngine;
import com.helpal.datar.rbiggy.framework.confchain.cores.OutputWrapper;

/**
 * 
 * Output Engine Conf
 *
 */
 public class OutputEngineConf extends OutputWrapper{
	 private String engineName = "Default bEngine BDIO";
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
		 System.out.println("Add Output Engine: " + outputEngine.getEngineName() + ".");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return outputEngine.getInfo() + ": " + getEngineName();
	 }
 }