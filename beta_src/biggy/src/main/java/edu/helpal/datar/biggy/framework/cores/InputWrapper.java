package edu.helpal.datar.biggy.framework.cores;

/**
 * Input Wrapper
 *
 */
 public abstract class InputWrapper implements Engine{
	 protected Engine inputEngine;
	 
	 public InputWrapper(Engine inputEngine){
		 this.inputEngine = inputEngine;
	 }
	 
	 public void start(){
		 inputEngine.start();
	 }
 }