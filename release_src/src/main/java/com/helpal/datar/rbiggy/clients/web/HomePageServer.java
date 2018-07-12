package com.helpal.datar.rbiggy.clients.web;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * Home Page Server
 *
 */
public class HomePageServer {
	void startHomePage() throws IOException {
		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");
		System.out.println("Your OS name: " + osName);

		if (osName.indexOf("Linux") != -1) {
			Runtime.getRuntime().exec("htmlview");
		} else if (osName.indexOf("Windows") != -1) {
			Runtime.getRuntime().exec("explorer http://localhost:8080");
		} else {
			throw new RuntimeException("Unknown OS.");
		}
	}
}
