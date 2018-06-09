package edu.helpal.datar.gbiggy.framework.datamodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * 
 * BigData IO
 * 
 */

public class BDIO {

	private BigData bigdata;

	public BDIO(BigData bigdata) {
		this.bigdata = bigdata;
	}

	public void ReadFromFile(String path) {
		System.out.println("Read from File: " + path);
		this.bigdata.content.put((long) 0, "LineContent");

		File dataFile = new File(path);
		BufferedReader br = null;
		long id = 1;
		try {
			br = new BufferedReader(new FileReader(dataFile));
			String line;
			while ((line = br.readLine()) != null) {
				this.bigdata.content.put(id, line);
				id += 1;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ee) {

				}
			}
		}
	}

}
