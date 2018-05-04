package edu.helpal.datar.biggy.framework.cores;

/**
 * Output Wrapper
 *
 */
 public abstract class OutputWrapper implements Engine{
	 protected Engine outputEngine;
	 
	 public OutputWrapper(Engine outputEngine){
		 this.outputEngine = outputEngine;
	 }
	 
	 public void start(){
		 outputEngine.start();
	 }
 }