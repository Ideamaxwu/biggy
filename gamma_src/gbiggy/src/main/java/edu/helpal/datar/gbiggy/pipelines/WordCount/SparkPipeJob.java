package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

/**
 * 
 * Spark Pipe Job for WordCount
 *
 */
public class SparkPipeJob {
	public void submit(BigData bigdata){
		System.out.println("submitting WordCount computation job on spark...");
		System.out.println("  innner Loooooooooooooooo");
		SparkPipeJobWordCount spwc = new SparkPipeJobWordCount();
		
		spwc.startWordCount(bigdata);
		
		System.out.println("  innner ooooooooooooooooG");
	}
}
