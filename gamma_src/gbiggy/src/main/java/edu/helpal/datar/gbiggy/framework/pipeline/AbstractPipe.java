package edu.helpal.datar.gbiggy.framework.pipeline;

public abstract class AbstractPipe {
	public static int HEAD = 6;
	public static int CONTROL = 5;
	public static int INPUT = 4;
	public static int STORAGE = 3;
	public static int COMPUTATION = 2;
	public static int OUTPUT = 1;
	
	protected int level;
	protected String pipeJob;
	
	protected AbstractPipe nextPipe;
	
	public void setNextPipe(AbstractPipe nextPipe){
		this.nextPipe = nextPipe;
	}
	
	public void pipeStart(int level, String message){
		if(this.level <= level && this.level != AbstractPipe.HEAD){
			start(message);
		}
		if(nextPipe != null){
			nextPipe.pipeStart(level, message);
		}
	}
	abstract protected void start(String message);
}
