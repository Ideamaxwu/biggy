package com.helpal.datar.rbiggy.bigo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.helpal.datar.rbiggy.framework.utils.BusKeeper;

/**
 * 
 * Server for running instance
 * 
 */
public class Server {
	
	private ServerSocket serverSocket;
	private int port = 9091;
	public BusKeeper context = null;
	
	public Server(BusKeeper bk) {
		this.context = bk;
	}

	public void start(){
		boolean runState = true;
		System.out.println("biggy instance bigo server starting...");
		String cmdPromts = "quit \t quit client \n"
				+ "close \t close server \n"
				+ "info \t check context info \n"
				+ "cmd \t go to Inception cmd";
		try {
			serverSocket = new ServerSocket(port);
			while (runState) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("accepting from new client");
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null && runState) {
					out.println(inputLine + " accepted by server.");
					System.out.println(inputLine + " accepted from client.");
					switch(inputLine.toLowerCase()){
					case "quit":
						System.out.println("client quiting...");	
						break;
					case "close":
						System.out.println("server closed.");
						out.println("server closed.");
						serverSocket.close();
						runState = false;
						break;
					case "info":
						//System.out.println(context.getContext().toString());
						out.println("Context info: "+context.getContext().toString());
						context.setContext("LOG" + context.logID, new Date().toString());
						context.logID += 1;
						break;
					case "cmd":
						System.out.println("Inception cmd starting...");	
						break;
					default:
						//System.out.println("Invalid Command!");
						out.println("Invalid Command!");
						//System.out.println(cmdPromts);
						out.println(cmdPromts);
						break;
					}
					out.println("SENDR");
				}
			}
		} catch (IOException e) {
			System.out.println(
					"Exception caught when trying to listen on port " + port + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}
