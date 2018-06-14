package edu.helpal.datar.gbiggy.pipelines.WordCount;

import java.lang.reflect.Method;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

/**
 * 
 * HBase Pipe Job for WordCount
 *
 */
public class HBasePipeJob {

	public void submit(BigData bigdata, String cls){
		System.out.println("submitting WordCount storage job on hbase...");
		System.out.println("  innner Loooooooooooooooo");
		
		//HBasePipeJobWriteDB bpjw = new HBasePipeJobWriteDB();
		//bpjw.startWriteFile(bigdata);
		
		Class<?> bpjw;
		Object obj;
		try {
			bpjw = Class.forName(cls);
			obj = bpjw.getConstructor().newInstance(); 
			Method meth = bpjw.getMethod("startWriteFile", BigData.class);
			meth.invoke(obj, bigdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("  innner ooooooooooooooooG");
	}
}
