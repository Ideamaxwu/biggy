package com.helpal.datar.rbiggy.examples.KMeans;

import java.io.IOException;
import java.util.Properties;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.framework.datamodel.bdio.fileBD;

public class egD3PipeJobVisual {
	public void startVisualPage(BigData bigdata) throws IOException {
		new fileBD(bigdata.getBD()).egVisualFile("src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\KMeans\\res\\cluster_data.json", "com.helpal.datar.rbiggy.examples.KMeans.egClusterD3PipeJobVisualTask001");
		bigdata.Show();
		
		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");

		System.out.println("Your OS name: " + osName);

		if (osName.indexOf("Linux") != -1) {
			Runtime.getRuntime().exec("htmlview");
		} else if (osName.indexOf("Windows") != -1) {
			Runtime.getRuntime().exec("explorer src\\main\\java\\com\\helpal\\datar\\rbiggy\\examples\\KMeans\\res\\cluster.html");
			
		} else {
			throw new RuntimeException("Unknown OS.");
		}
	}
}
