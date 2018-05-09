package edu.helpal.datar.biggy.framework.pipeline;

public class OutputPipe extends AbstractPipe{
	public OutputPipe(int level){
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Output Engine::Pipe: " + message);
	}
}
