package edu.helpal.datar.gbiggy.framework.pipeline;

import java.text.SimpleDateFormat;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public abstract class AbstractPipe {
	public static int HEAD = 6;
	public static int CONTROL = 5;
	public static int INPUT = 4;
	public static int STORAGE = 3;
	public static int COMPUTATION = 2;
	public static int OUTPUT = 1;
	
	protected int level;
	protected String pipeJob;
	protected BigData bigdata;
	
	protected AbstractPipe nextPipe;
	
	public void setNextPipe(AbstractPipe nextPipe){
		this.nextPipe = nextPipe;
	}
	
	public void bindBigData(BigData bigdata){
		this.bigdata = bigdata;
	}
	public void pipeStart(int level, String message, BigData bigdata){
		
		bindBigData(bigdata);
		
		Runtime run = Runtime.getRuntime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
		
		if(this.level <= level && this.level != AbstractPipe.HEAD){
			System.out.println("<TIME "+ this.level +">: "+df.format(System.currentTimeMillis()));
			System.out.println("<Memory" + this.level +"> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
			start(message);
		}
		if(nextPipe != null){
			nextPipe.pipeStart(level, message, bigdata);
		}
	}
	abstract protected void start(String message);
}
