package edu.helpal.datar.biggy.framework.pipeline;

public class HeadPipe extends AbstractPipe{
	public HeadPipe(int level){
		this.level = level;
	}

	@Override
	protected void start(String message) {
		System.out.println("Head Pipe::Pipeline: " + message);
	}
}
