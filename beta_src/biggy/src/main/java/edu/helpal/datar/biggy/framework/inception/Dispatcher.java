package edu.helpal.datar.biggy.framework.inception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * Dispatcher
 *
 */

public class Dispatcher {
	
	void Dispatch(String engineName, String jobName, String job){
		//TODO dispatch
		commandParse(job);
		dispatchPoolTest();
		System.out.println("Dispatching Job " + jobName +" to Engine " + engineName);
	}
	
	void dispatchPoolTest(){
		//TODO thread pool
		final int MAX_T = 3;
		Runnable r1 = new DispatchTask("Task 001");
		Runnable r2 = new DispatchTask("Task 002");
		Runnable r3 = new DispatchTask("Task 003");
		Runnable r4 = new DispatchTask("Task 004");
		Runnable r5 = new DispatchTask("Task 005");
		
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
		
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		
		pool.shutdown();
		
	}
	
	void commandParse(String job){
		//TODO command line argument parse
		String[] args = getArgs(job);
		System.out.println("Job: " + args[0] + " dataFile: " + args[1] + " by " +args[2]);
	}
	
	String[] getArgs(String jobstr){
		String[] args = jobstr.trim().replace("-", "").split(" ");
		return args;
	}

}
