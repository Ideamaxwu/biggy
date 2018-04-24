package biggy.framework.cores;

/**
 * Computation Wrapper
 *
 */
 public abstract class ComputationWrapper implements Engine{
	 protected Engine computationEngine;
	 
	 public ComputationWrapper(Engine computationEngine){
		 this.computationEngine = computationEngine;
	 }
	 
	 public void start(){
		 computationEngine.start();
	 }
 }