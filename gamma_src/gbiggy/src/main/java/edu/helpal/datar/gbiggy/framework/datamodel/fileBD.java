package edu.helpal.datar.gbiggy.framework.datamodel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

import edu.helpal.datar.gbiggy.pipelines.WordCount.D3PipeJobVisualTask001;

/**
 * 
 * BigData <=> file IO
 * 
 */

public class fileBD {

	private BigData bigdata;

	public fileBD(BigData bigdata) {
		this.bigdata = bigdata;
	}

	public void ReadFromFile(String path) {
		System.out.println("Read from File: " + path);

		File dataFile = new File(path);
		BufferedReader br = null;
		long id = 0;
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

	public void WriteToFile(String path) {
		System.out.println("Write to File: " + path);
		File dataFile = new File(path);
		
		BufferedWriter bw = null;
		try {
			if(!dataFile.exists()){
				dataFile.createNewFile();
			}
			bw = new BufferedWriter(new FileWriter(dataFile));
			for (Entry<Long, String> entry : this.bigdata.content.entrySet()){
				bw.write(entry.getValue());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ee) {

				}
			}
		}
	}

	public void VisualFile(String path) {
		System.out.println("Write to Visual Data File: " + path);
		new D3PipeJobVisualTask001().generate(this.bigdata.content, path);
	}

}
