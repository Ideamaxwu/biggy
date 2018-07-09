package com.helpal.datar.rbiggy.framework.pipeline;

/**
 * 
 * Storage Pipe
 *
 */
public class StoragePipe extends AbstractPipe{
	public StoragePipe(int level, String pipeJob){
		this.level = level;
		this.pipeJob = pipeJob;
	}

	@Override
	protected void start(String message) {
		System.out.println("Storege Pipe::Pipeline: "  + this.pipeJob + " " + message);
	}
}
