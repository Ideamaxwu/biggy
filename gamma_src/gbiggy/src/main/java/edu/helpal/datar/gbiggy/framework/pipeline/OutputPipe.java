package edu.helpal.datar.gbiggy.framework.pipeline;

public class OutputPipe extends AbstractPipe{
	public OutputPipe(int level, String pipeJob){
		this.level = level;
		this.pipeJob = pipeJob;
	}

	@Override
	protected void start(String message) {
		System.out.println("Output Pipe::Pipeline: " + this.pipeJob + " " + message);
	}
}
