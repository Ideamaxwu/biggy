package edu.helpal.datar.gbiggy.framework.cores;

/**
 * Input Wrapper
 *
 */
 public abstract class InputWrapper implements IEngine{
	 protected IEngine inputEngine;
	 
	 public InputWrapper(IEngine inputEngine){
		 this.inputEngine = inputEngine;
	 }
	 
	 public void start(){
		 inputEngine.start();
	 }
 }