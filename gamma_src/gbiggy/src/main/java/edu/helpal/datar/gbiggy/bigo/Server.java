package edu.helpal.datar.gbiggy.bigo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import edu.helpal.datar.gbiggy.framework.utils.BusKeeper;

/*
 * 
 * Server
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
		try {
			serverSocket = new ServerSocket(port);
			while (runState) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("accepting from new client");
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					out.println(inputLine + " accepted by server.");
					System.out.println(inputLine + " accepted from client.");
					if(inputLine.equalsIgnoreCase("quit")){
						System.out.println("client quiting...");
					}
					if(inputLine.equalsIgnoreCase("close")){
						serverSocket.close();
						System.out.println("server closed.");
						runState = false;
						break;
					}
					if(inputLine.equalsIgnoreCase("info")){
						System.out.println(context.getContext().toString());
						context.setContext("LOG" + context.logID, new Date().toString());
						context.logID += 1;
					}
				}
			}
		} catch (IOException e) {
			System.out.println(
					"Exception caught when trying to listen on port " + port + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}
