package edu.helpal.datar.gbiggy.pipelines.WordCount;

import java.io.IOException;
import java.util.Properties;

public class D3PipeJobVisual {
	public void startWebPage() throws IOException {
		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");

		System.out.println("Your OS name: " + osName);

		if (osName.indexOf("Linux") != -1) {
			Runtime.getRuntime().exec("htmlview");
		} else if (osName.indexOf("Windows") != -1) {
			Runtime.getRuntime().exec("explorer src\\main\\java\\edu\\helpal\\datar\\gbiggy\\pipelines\\WordCount\\res\\index.html");
		} else {
			throw new RuntimeException("Unknown OS.");
		}
	}
}
