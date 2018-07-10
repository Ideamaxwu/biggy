package com.helpal.datar.rbiggy.pipelines.jobs;

import java.lang.reflect.Method;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;

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
			Method meth = bpjw.getMethod("startWriteDB", BigData.class);
			meth.invoke(obj, bigdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("  innner ooooooooooooooooG");
	}
}
