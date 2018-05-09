package edu.helpal.datar.biggy.framework.cores;

/**
 * Output Wrapper
 *
 */
 public abstract class OutputWrapper implements IEngine{
	 protected IEngine outputEngine;
	 
	 public OutputWrapper(IEngine outputEngine){
		 this.outputEngine = outputEngine;
	 }
	 
	 public void start(){
		 outputEngine.start();
	 }
 }