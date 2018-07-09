package com.helpal.datar.rbiggy.framework.inception;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * Dispatch Task
 *
 */
public class DispatchTask implements Runnable{
	private String taskName;
	
	public DispatchTask(String name){
		taskName = name;
	}
	public void run() {
		// TODO Auto-generated method stub
		try{
			for(int i=0; i<5; i++){
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
				if(i==0){
					System.out.println("Initialization Time for task name - " + taskName + " = " + sdf.format(date));
				}
				else{
					System.out.println("Executing Time for task name - " + taskName + " = " + sdf.format(date));
				}
				Thread.sleep(1000);
			}
			System.out.println(taskName + " completed.");
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
