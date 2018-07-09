package com.helpal.datar.rbiggy.framework.pipeline;

/**
 * 
 * Input Pipe
 *
 */
public class InputPipe extends AbstractPipe{
	public InputPipe(int level, String pipeJob){
		this.level = level;
		this.pipeJob = pipeJob;
	}

	@Override
	protected void start(String message) {
		System.out.println("Input Pipe::Pipeline: " + this.pipeJob + " " + message);
	}
}
