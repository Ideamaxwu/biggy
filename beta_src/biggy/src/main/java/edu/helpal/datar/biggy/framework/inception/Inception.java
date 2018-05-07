package edu.helpal.datar.biggy.framework.inception;

import java.util.Scanner;

/**
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
		 sc = new Scanner(System.in); 
		 System.out.print(prompt);
		 String cmdLine = sc.nextLine().toLowerCase();
		 while (!cmdLine.equals("quit")){
			 switch(cmdLine){
			 case "input":
				 System.out.println("Input engine working...");
				 //processing
				 
				 System.out.print(prompt);
				 break;
			 case "store":
				 System.out.println("Storage engine working...");
				 //processing
				 dp.Dispatch("Spark", "DBWordCountJob");
				 System.out.print(prompt);
				 break;
			 case "compute":
				 System.out.println("Computation engine working...");
				 //processing
				 
				 System.out.print(prompt);
				 break;
			 case "control":
				 System.out.println("Control engine working...");
				 //processing
				 
				 System.out.print(prompt);
				 break;
			 case "output":
				 System.out.println("Output engine working...");
				 //processing
				 
				 System.out.print(prompt);
				 break;
			 default:
				 System.out.println("Invalid Command!");
				 //processing
				 
				 System.out.print(prompt);
				 break;
			 }
			 cmdLine = sc.nextLine().toLowerCase();
		 }
		 System.out.println(">>>>>>biggy Console Exit<<<<<<");
	 }
}