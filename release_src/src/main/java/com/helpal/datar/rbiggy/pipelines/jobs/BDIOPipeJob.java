package com.helpal.datar.rbiggy.pipelines.jobs;

import java.lang.reflect.Method;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;

/**
 * 
 * BDIO Pipe Job for WordCount
 *
 */
public class BDIOPipeJob {
	public void submit(BigData bigdata, String cls){
		System.out.println("submitting WordCount input job on bdio...");
		
		System.out.println("  innner Loooooooooooooooo");
		//BDIOPipeJobReadFile bpjr = new BDIOPipeJobReadFile();
		//bpjr.startReadFile(bigdata);
		
		Class<?> bpjr;
		Object obj;
		try {
			bpjr = Class.forName(cls);
			obj = bpjr.getConstructor().newInstance(); 
			Method meth = bpjr.getMethod("startReadFile", BigData.class);
			meth.invoke(obj, bigdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("  innner ooooooooooooooooG");
	}
}
