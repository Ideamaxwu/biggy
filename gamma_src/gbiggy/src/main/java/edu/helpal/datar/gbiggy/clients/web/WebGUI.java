package edu.helpal.datar.gbiggy.clients.web;

import java.io.IOException;

/**
 * WebGUI
 *
 */
public class WebGUI {

	public static void main(String[] args) throws IOException {
				WebServer webServer = new WebServer(9090);
        new Thread(webServer).start();
        
        WebSeverHome wsh = new WebSeverHome();
		wsh.startWebHome();
	}
}
