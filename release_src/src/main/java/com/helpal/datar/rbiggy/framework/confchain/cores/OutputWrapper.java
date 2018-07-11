package com.helpal.datar.rbiggy.framework.confchain.cores;

/**
 * 
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