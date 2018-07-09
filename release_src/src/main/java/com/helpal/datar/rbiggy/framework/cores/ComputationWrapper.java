package com.helpal.datar.rbiggy.framework.cores;

/**
 * 
 * Computation Wrapper
 *
 */
 public abstract class ComputationWrapper implements IEngine{
	 protected IEngine computationEngine;
	 
	 public ComputationWrapper(IEngine computationEngine){
		 this.computationEngine = computationEngine;
	 }
	 
	 public void start(){
		 computationEngine.start();
	 }
 }