package edu.helpal.datar.biggy.framework.cores;

/**
 * Computation Engine Spark
 *
 */
 public class ComputationEngineSpark extends ComputationWrapper{
	 private String engineName = "Spark";
	 
	 public ComputationEngineSpark(Engine computationEngine){
		 super(computationEngine);
	 }
	 
	 @Override
	 public void start(){
		 computationEngine.start();
		 setComputationEngine(computationEngine);
	 }
	 
	 private void setComputationEngine(Engine computationEngine){
		 System.out.println("Add Computation Engine: Spark.");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 public String getInfo(){
		 return computationEngine.getInfo() + ": " + getEngineName();
	 }
 }