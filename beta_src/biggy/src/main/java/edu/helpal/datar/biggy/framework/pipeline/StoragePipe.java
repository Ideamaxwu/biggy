package edu.helpal.datar.biggy.framework.pipeline;

public class StoragePipe extends AbstractPipe{
	public StoragePipe(int level){
		this.level = level;
	}

	@Override
	protected void start(String message) {
		System.out.println("Storege Pipe::Pipeline: " + message);
	}
}
