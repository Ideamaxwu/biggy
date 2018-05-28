package edu.helpal.datar.gbiggy.engines.computation;

import edu.helpal.datar.gbiggy.framework.cores.IEngine;
import edu.helpal.datar.gbiggy.framework.cores.ComputationWrapper;

/**
 * Computation Engine Conf
 *
 */
 public class ComputationEngineConf extends ComputationWrapper{
	 private String engineName = "Default XXX";
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