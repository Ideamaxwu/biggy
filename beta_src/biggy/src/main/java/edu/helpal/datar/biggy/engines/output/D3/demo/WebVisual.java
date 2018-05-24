package edu.helpal.datar.biggy.engines.output.D3.demo;

import java.io.IOException;
import java.util.Properties;

public class WebVisual {
	public void startWebPage() throws IOException {
		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");

		System.out.println("Your OS name: " + osName);

		if (osName.indexOf("Linux") != -1) {
			Runtime.getRuntime().exec("htmlview");
		} else if (osName.indexOf("Windows") != -1) {
			Runtime.getRuntime().exec("explorer src\\main\\java\\edu\\helpal\\datar\\biggy\\engines\\output\\D3\\demo\\index.html");
		} else {
			throw new RuntimeException("Unknown OS.");
		}
	}
}
