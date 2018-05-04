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
	 
	 public void start(){
		 System.out.println(">>>>>>biggy Console<<<<<<");
		 prompt = "Please input your command: > ";
		 sc = new Scanner(System.in); 
		 System.out.print(prompt);
		 String cmdLine = sc.nextLine().toLowerCase();
		 while (!cmdLine.equals("quit")){
			 switch(cmdLine){
			 case "store":
				 System.out.println("Storage engine working...");
				 //processing
				 
				 System.out.print(prompt);
				 break;
			 case "compute":
				 System.out.println("Computation engine working...");
				 //processing
				 
				 System.out.print(prompt);
				 break;
			 default:
				 System.out.print(prompt);
				 break;
			 }
			 cmdLine = sc.nextLine().toLowerCase();
		 }
		 System.out.println(">>>>>>biggy Console Exit<<<<<<");
	 }
}