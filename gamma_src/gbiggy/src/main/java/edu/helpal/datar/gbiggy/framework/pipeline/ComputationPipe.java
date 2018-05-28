package edu.helpal.datar.gbiggy.framework.pipeline;

public class ComputationPipe extends AbstractPipe{
	public ComputationPipe(int level, String pipeJob){
		this.level = level;
		this.pipeJob = pipeJob;
	}

	@Override
	protected void start(String message) {
		System.out.println("Computation Pipe::Pipeline: " + this.pipeJob + " " + message);
	}
}
