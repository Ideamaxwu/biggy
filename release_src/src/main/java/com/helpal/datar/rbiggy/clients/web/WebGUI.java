package com.helpal.datar.rbiggy.clients.web;

import java.io.IOException;

/**
 * 
 * WebGUI
 *
 */
public class WebGUI {

	public static void main(String[] args) throws IOException {
		WebServer webServer = new WebServer(9092);
		webServer.start();

		HomePageServer hps = new HomePageServer();
		hps.startHomePage();
	}
}
