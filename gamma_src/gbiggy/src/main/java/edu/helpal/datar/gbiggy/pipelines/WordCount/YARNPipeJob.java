package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

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
