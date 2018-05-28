package edu.helpal.datar.gbiggy.engines.output;

import edu.helpal.datar.gbiggy.framework.cores.IEngine;
import edu.helpal.datar.gbiggy.framework.cores.OutputWrapper;

/**
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