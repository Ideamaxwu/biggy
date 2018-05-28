package edu.helpal.datar.gbiggy.framework.pipeline;

public class ControlPipe extends AbstractPipe{
	public ControlPipe(int level, String pipeJob){
		this.level = level;
		this.pipeJob = pipeJob;
	}

	@Override
	protected void start(String message) {
		System.out.println("Control Pipe::Pipeline: " + this.pipeJob + " " + message);
	}
}
