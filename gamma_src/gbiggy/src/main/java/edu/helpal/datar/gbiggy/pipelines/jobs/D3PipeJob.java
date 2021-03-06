package edu.helpal.datar.gbiggy.pipelines.jobs;

import java.lang.reflect.Method;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

/**
 * 
 * D3 Pipe Job for WordCount
 *
 */
public class D3PipeJob {
	
	public void submit(BigData bigdata, String cls){
		System.out.println("submitting WordCount output job on d3...");
		System.out.println("  inner Loooooooooooooooo");
		
		/*
		D3PipeJobVisual dpjv = new D3PipeJobVisual();
		try {
			dpjv.startVisualPage(bigdata);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		Class<?> dpjv;
		Object obj;
		try {
			dpjv = Class.forName(cls);
			obj = dpjv.getConstructor().newInstance(); 
			Method meth = dpjv.getMethod("startVisualPage", BigData.class);
			meth.invoke(obj, bigdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("  innner ooooooooooooooooG");
	}
}
