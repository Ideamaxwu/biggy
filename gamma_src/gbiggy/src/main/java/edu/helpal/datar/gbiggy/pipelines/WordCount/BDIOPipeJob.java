package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

/**
 * 
 * BDIO Pipe Job for WordCount
 *
 */
public class BDIOPipeJob {
	public void submit(BigData bigdata){
		System.out.println("submitting WordCount input job on bdio...");
		System.out.println("  innner Loooooooooooooooo");
		BDIOPipeJobReadFile bpjr = new BDIOPipeJobReadFile();
		
		bpjr.startReadFile(bigdata);
		
		System.out.println("  innner ooooooooooooooooG");
	}
}
