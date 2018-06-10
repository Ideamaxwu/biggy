package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

/**
 * 
 * HBase Pipe Job for WordCount
 *
 */
public class HBasePipeJob {
	public void submit(BigData bigdata){
		System.out.println("submitting WordCount storage job on hbase...");
		System.out.println("  innner Loooooooooooooooo");
		HBasePipeJobWriteDB bpjw = new HBasePipeJobWriteDB();
		
		bpjw.startWriteFile(bigdata);
		
		System.out.println("  innner ooooooooooooooooG");
	}
}
