package edu.helpal.datar.biggy.framework.pipeline;

public class InputPipe extends AbstractPipe{
	public InputPipe(int level){
		this.level = level;
	}

	@Override
	protected void start(String message) {
		System.out.println("Input Pipe::Pipeline: " + message);
	}
}
