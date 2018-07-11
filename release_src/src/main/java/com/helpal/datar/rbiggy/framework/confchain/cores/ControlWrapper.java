package com.helpal.datar.rbiggy.framework.confchain.cores;

/**
 * 
 * Control Wrapper
 *
 */
 public abstract class ControlWrapper implements IEngine{
	 protected IEngine controlEngine;
	 
	 public ControlWrapper(IEngine controlEngine){
		 this.controlEngine = controlEngine;
	 }
	 
	 public void start(){
		 controlEngine.start();
	 }
 }