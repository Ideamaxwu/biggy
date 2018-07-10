package com.helpal.datar.rbiggy.framework.inception;

import java.util.Scanner;

/**
 * 
 * Inception Layer
 *
 */
public class Inception
{
	 private String prompt;
	 private Scanner sc;
	 private Dispatcher dp;
	 
	 public void start(){
		 dp = new Dispatcher();
		 System.out.println(">>>>>>biggy Console<<<<<<");
		 prompt = "Please input your command: > ";
		 String cmdPrompts = "TRY: input \t store \t compute \t control \t output \t or quit";
		 sc = new Scanner(System.in); 
		 System.out.print(prompt);
		 String cmdLine = sc.nextLine().toLowerCase();
		 while (!cmdLine.equals("quit")){
			 switch(cmdLine){
			 case "input":
				 System.out.println("Input engine working...");
				 //TODO processing
				 
				 System.out.print(prompt);
				 break;
			 case "store":
				 System.out.println("Storage engine working...");
				 //TODO processing
				 
				 System.out.print(prompt);
				 break;
			 case "compute":
				 System.out.println("Computation engine working...");
				 //TODO processing
				 dp.Dispatch("Spark", "DBWordCountJob", "-analysis DBcount.txt Iteration");
				 System.out.print(prompt);
				 break;
			 case "control":
				 System.out.println("Control engine working...");
				 //TODO processing
				 
				 System.out.print(prompt);
				 break;
			 case "output":
				 System.out.println("Output engine working...");
				 //TODO processing
				 
				 System.out.print(prompt);
				 break;
			 default:
				 System.out.println("Invalid Command!");
				 //TODO processing
				 System.out.println(cmdPrompts);
				 System.out.print(prompt);
				 break;
			 }
			 cmdLine = sc.nextLine().toLowerCase();
		 }
		 System.out.println(">>>>>>biggy Console Exit<<<<<<");
	 }
	 
	 public void init(){
		 System.out.println("Inception initializing...");
	 }
}