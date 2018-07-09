package com.helpal.datar.rbiggy.clients.cli;

/**
 * 
 * Command CLIent
 *
 */
public class CliGUI {
	public static void main(String[] args){
		System.out.println("biggy CLI working...");
		CliClient client = new CliClient();
		client.startClient();
	}
}