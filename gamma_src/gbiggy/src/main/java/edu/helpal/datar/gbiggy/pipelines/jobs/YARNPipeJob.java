package edu.helpal.datar.gbiggy.pipelines.jobs;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;
import edu.helpal.datar.gbiggy.pipelines.WordCount.YARNPipeJobResConf;

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
