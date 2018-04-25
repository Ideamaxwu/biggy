package biggy.framework.cores;

/**
 * Computation Engine
 *
 */
 public class ComputationEngine implements Engine{
	 private String engineType = "ComputationEngine";
	 
	 @Override
	 public void start(){
		 System.out.println("Computation Engine Initializing.");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 @Override
	 public String getInfo(){
		 return getEngineType();
	 };
 }