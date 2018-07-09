package com.helpal.datar.rbiggy.pipelines.jobs;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.pipelines.WordCount.YARNPipeJobResConf;

/**
 * 
 * YARN Pipe Job for WordCount
 *
 */
public class YARNPipeJob {
	public void submit(BigData bigdata){
		System.out.println("submitting WordCount control job on yarn...");
		System.out.println("  innner Loooooooooooooooo");
		YARNPipeJobResConf yprs = new YARNPipeJobResConf();
		
		yprs.startResConf(bigdata);
		
		System.out.println("  innner ooooooooooooooooG");
	}
}
