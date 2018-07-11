package com.helpal.datar.rbiggy.engines.computation;

import com.helpal.datar.rbiggy.framework.confchain.cores.ComputationWrapper;
import com.helpal.datar.rbiggy.framework.confchain.cores.IEngine;

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
		 System.out.println("Add Computation Engine: " + computationEngine.getEngineName() + ".");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return computationEngine.getInfo() + ": " + getEngineName();
	 }
 }