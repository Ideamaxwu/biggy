package biggy.framework.cores;

/**
 * Computation Engine Spark
 *
 */
 public class ComputationEngineSpark extends ComputationWrapper{
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
 }