package edu.helpal.datar.biggy.framework.inception;

/**
 * 
 * Dispatcher
 *
 */

public class Dispatcher {
	
	void Dispatch(String engineName, String jobName, String job){
		//TODO dispatch
		commandParse(job);
		dispatchPool();
		System.out.println("Dispatching Job " + jobName +" to Engine " + engineName);
	}
	
	void dispatchPool(){
		//TODO thread pool
		
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
