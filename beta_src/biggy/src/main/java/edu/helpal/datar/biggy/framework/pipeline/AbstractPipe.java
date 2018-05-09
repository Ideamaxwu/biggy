package edu.helpal.datar.biggy.framework.pipeline;

public abstract class AbstractPipe {
	public static int INPUT = 1;
	public static int STORAGE = 2;
	public static int OUTPUT = 5;
	
	protected int level;
	
	protected AbstractPipe nextPipe;
	
	public void setNextPipe(AbstractPipe nextPipe){
		this.nextPipe = nextPipe;
	}
	
	public void pipeMessage(int level, String message){
		if(this.level <= level){
			write(message);
		}
		if(nextPipe != null){
			nextPipe.pipeMessage(level, message);
		}
	}
	abstract protected void write(String message);
}
