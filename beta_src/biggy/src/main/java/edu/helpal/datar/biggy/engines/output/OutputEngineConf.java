package edu.helpal.datar.biggy.engines.output;

import edu.helpal.datar.biggy.framework.cores.Engine;
import edu.helpal.datar.biggy.framework.cores.OutputWrapper;

/**
 * Output Engine Conf
 *
 */
 public class OutputEngineConf extends OutputWrapper{
	 private String engineName = "Default XXX";
	 
	 public OutputEngineConf(Engine outputEngine, String confEngineName){
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
		 System.out.println("Add Output Engine: " + engineName + ".");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return outputEngine.getInfo() + ": " + getEngineName();
	 }
 }