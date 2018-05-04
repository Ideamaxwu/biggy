package edu.helpal.datar.biggy.framework.cores;

/**
 * Control Wrapper
 *
 */
 public abstract class ControlWrapper implements Engine{
	 protected Engine controlEngine;
	 
	 public ControlWrapper(Engine controlEngine){
		 this.controlEngine = controlEngine;
	 }
	 
	 public void start(){
		 controlEngine.start();
	 }
 }