package edu.helpal.datar.gbiggy.examples.PageRank;

import java.io.IOException;
import java.util.Properties;

import edu.helpal.datar.gbiggy.framework.datamodel.fileBD;
import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

public class egD3PipeJobVisual {
	public void startVisualPage(BigData bigdata) throws IOException {
		new fileBD(bigdata.getBD()).egPRVisualFile("src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\PageRank\\res\\pagerank_data.js");
		//bigdata.Show();
		
		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");

		System.out.println("Your OS name: " + osName);

		if (osName.indexOf("Linux") != -1) {
			Runtime.getRuntime().exec("htmlview");
		} else if (osName.indexOf("Windows") != -1) {
			Runtime.getRuntime().exec("explorer src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\PageRank\\res\\pagerank.html");
			
		} else {
			throw new RuntimeException("Unknown OS.");
		}
	}
}
