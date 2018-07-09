package com.helpal.datar.rbiggy.pipelines.jobs;

import java.lang.reflect.Method;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;

/**
 * 
 * Spark Pipe Job for WordCount
 *
 */
public class SparkPipeJob {
	
	public void submit(BigData bigdata, String cls){
		System.out.println("submitting WordCount computation job on spark...");
		System.out.println("  innner Loooooooooooooooo");
		
		//SparkPipeJobWordCount spwc = new SparkPipeJobWordCount();
		//spwc.startWordCount(bigdata);
		
		Class<?> spwc;
		Object obj;
		try {
			spwc = Class.forName(cls);
			obj = spwc.getConstructor().newInstance(); 
			Method meth = spwc.getMethod("startWordCount", BigData.class);
			meth.invoke(obj, bigdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("  innner ooooooooooooooooG");
	}
}
