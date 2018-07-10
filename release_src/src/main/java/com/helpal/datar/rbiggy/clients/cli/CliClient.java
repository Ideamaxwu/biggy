package com.helpal.datar.rbiggy.clients.cli;

/**
 * 
 * Client
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.helpal.datar.rbiggy.framework.inception.Inception;

public class CliClient {
	
	private Socket clientSocket;
	private String host = "localhost";
	private int port = 9091;
	
	public void startClient(){
		System.out.print("client> ");
		try{
			clientSocket = new Socket(host, port);  
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);  
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); 
            String userInput;  
            String line;
            boolean runState = true;
            while ((userInput = stdIn.readLine()) != null && runState) {  
            	out.println(userInput);
            	while(!(line = in.readLine()).equals("SENDR"))
            		System.out.println(line); 
            	switch(userInput.toLowerCase()){
            	case "quit":
            		System.out.print("client closed.");
            		clientSocket.close();
            		runState = false;
            		break;
            	case "cmd":
            		System.out.println("starting Inception console...");
            		Inception incp = new Inception();
                	incp.start();
                	System.out.print("client> ");
            		break;
            	default:
            		System.out.print("client> ");
            		break;
            	}
            }
		} catch(UnknownHostException e){
			System.err.println("Don't know about host " + host);  
            System.exit(1);
		} catch(IOException e){
			System.err.println("Couldn't get I/O for the connection to " + host + "!");
			System.err.println("Check the avalability of the server!");
            System.exit(1);
		}
	}
}
