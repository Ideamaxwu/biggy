package edu.helpal.datar.gbiggy.bigo;

import java.util.List;

import edu.helpal.datar.gbiggy.framework.cores.IEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * InstanceBDMS
 *
 */
public class InstanceBDMS {

	private static InstanceBDMS instance = null;
	private List<IEngine> engineList = new ArrayList<IEngine>();
	private ServerSocket serverSocket;

	private InstanceBDMS() {
	}

	public static InstanceBDMS getInstance() {
		if (instance == null) {
			instance = new InstanceBDMS();
			System.out.println("Single Instance BDMS Bigo Created.");
		} else {
			System.out.println("Instance Object Bigo Existed. DO NOT DUPLICATE!");
		}
		return instance;
	}

	public void addEngine(IEngine engine) {
		engine.start();
		engineList.add(engine);
	}

	public void startServer() {
		int port = 9091;
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
				}
			}
		} catch (IOException e) {
			System.out.println(
					"Exception caught when trying to listen on port " + port + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}

	public void showInfo() {
		System.out.println("-----biggy Status Info-----");
		for (IEngine engine : engineList) {
			System.out.println(engine.getInfo());
		}
		System.out.println("-----biggy Status Info END-----");
	}
}