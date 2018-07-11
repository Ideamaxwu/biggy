package com.helpal.datar.rbiggy.framework.datamodel.bdio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;

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
				this.bigdata.getContent().put(id, line);
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
			for (Entry<Long, String> entry : this.bigdata.getContent().entrySet()){
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
	
	public void egVisualFile(String path, String cls) {
		System.out.println("Write to Visual Data File: " + path);
		//new egD3PipeJobVisualTask001().generate(this.bigdata.getContent(), path);
		Class<?> egVF;
		Object obj;
		try {
			egVF = Class.forName(cls);
			obj = egVF.getConstructor().newInstance(); 
			Method meth = egVF.getMethod("generate", Map.class, String.class);
			meth.invoke(obj, this.bigdata.getContent(), path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	public void egSortVisualFile(String path) {
		System.out.println("Write to Visual Data File: " + path);
		new egSortD3PipeJobVisualTask001().generate(this.bigdata.getContent(), path);
	}

	public void egClusterVisualFile(String path) {
		System.out.println("Write to Visual Data File: " + path);
		new egClusterD3PipeJobVisualTask001().generate(this.bigdata.getContent(), path);
	}
	
	public void egPRVisualFile(String path) {
		System.out.println("Write to Visual Data File: " + path);
		new egPageRankD3PipeJobVisualTask001().generate(this.bigdata.getContent(), path);
	}
	*/
}
