package com.helpal.datar.rbiggy.engines.computation;

import com.helpal.datar.rbiggy.framework.cores.IEngine;
import com.helpal.datar.rbiggy.framework.cores.ComputationWrapper;

/**
 * 
 * Computation Engine Conf
 *
 */
 public class ComputationEngineConf extends ComputationWrapper{
	 private String engineName = "Default bEngine Abacus";
	 private ComputationEngineFactory computationEngineFactory = new ComputationEngineFactory(); 
	 
	 public ComputationEngineConf(IEngine computationEngine, String confEngineName){
		 super(computationEngine);
		 if (confEngineName != null){
			engineName = confEngineName; 
		 }
	 }
	 
	 @Override
	 public void start(){
		 computationEngine.start();
		 setComputationEngine();
	 }
	 
	 private void setComputationEngine(){
		 IComputationEngine computationEngine = computationEngineFactory.getComputationEngine(engineName);
		 computationEngine.setup();
		 System.out.println("Add Computation Engine: " + engineName + ".");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return computationEngine.getInfo() + ": " + getEngineName();
	 }
 }