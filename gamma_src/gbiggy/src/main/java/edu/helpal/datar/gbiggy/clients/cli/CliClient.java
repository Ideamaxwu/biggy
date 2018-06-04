package edu.helpal.datar.gbiggy.clients.cli;

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

import edu.helpal.datar.gbiggy.framework.inception.Inception;

public class CliClient {
	private Socket clientSocket;

	public void startClient(){
		System.out.print("client> ");
		String host = "localhost";
		int port = 9091;
		try{
			clientSocket = new Socket(host, port);  
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);  
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); 
            String userInput;  
            while ((userInput = stdIn.readLine()) != null) {  
            	out.println(userInput);  
            	System.out.println(in.readLine()); 
            	System.out.print("client> ");
            	if(userInput.equalsIgnoreCase("quit")){
            		System.out.print("client closed.");
            		clientSocket.close();
            		break;
            	}
            	if(userInput.equalsIgnoreCase("cmd")){
            		System.out.print("starting command console...");
            		Inception incp = new Inception();
                	incp.start();
            	}
            }
		} catch(UnknownHostException e){
			System.err.println("Don't know about host " + host);  
            System.exit(1);
		} catch(IOException e){
			System.err.println("Couldn't get I/O for the connection to " + host);  
            System.exit(1);
		}
	}
}
