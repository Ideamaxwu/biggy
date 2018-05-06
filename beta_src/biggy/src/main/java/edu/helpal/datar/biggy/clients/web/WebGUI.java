package edu.helpal.datar.biggy.clients.web;

import java.util.Properties;
import java.io.IOException;

/**
 * WebGUI
 *
 */
public class WebGUI {

	public static void main(String[] args) throws IOException {

		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");

		System.out.println("Your OS name: " + osName);

		if (osName.indexOf("Linux") != -1) {
			Runtime.getRuntime().exec("htmlview");
		} else if (osName.indexOf("Windows") != -1) {
			Runtime.getRuntime().exec("explorer src\\main\\java\\edu\\helpal\\datar\\biggy\\clients\\web\\index.html");
		} else {
			throw new RuntimeException("Unknown OS.");
		}
	}
}
