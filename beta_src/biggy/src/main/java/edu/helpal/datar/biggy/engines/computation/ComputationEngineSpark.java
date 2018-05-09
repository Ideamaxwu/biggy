package edu.helpal.datar.biggy.engines.computation;

import edu.helpal.datar.biggy.framework.cores.ComputationWrapper;
import edu.helpal.datar.biggy.framework.cores.IEngine;

/**
 * Computation Engine Spark
 *
 */
 public class ComputationEngineSpark extends ComputationWrapper{
	 private String engineName = "Spark";
	 
	 public ComputationEngineSpark(IEngine computationEngine){
		 super(computationEngine);
	 }
	 
	 @Override
	 public void start(){
		 computationEngine.start();
		 setComputationEngine(computationEngine);
		 runEngine();
	 }
	 
	 private void setComputationEngine(IEngine computationEngine){
		 System.out.println("Add Computation Engine: Spark.");
	 }
	 
	 private void runEngine(){
		 SparkEngine sparkngn = new SparkEngine();
		 sparkngn.run();
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return computationEngine.getInfo() + ": " + getEngineName();
	 }
 }