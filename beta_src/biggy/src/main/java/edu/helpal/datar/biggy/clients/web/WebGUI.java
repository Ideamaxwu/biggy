package edu.helpal.datar.biggy.clients.web;

import java.io.IOException;

/**
 * WebGUI
 *
 */
public class WebGUI {

	public static void main(String[] args) throws IOException {
		WebSinglePage whp = new WebSinglePage();
		whp.startWebPage();
		
		WebServer webServer = new WebServer(9090);
        new Thread(webServer).start();
	}
}
