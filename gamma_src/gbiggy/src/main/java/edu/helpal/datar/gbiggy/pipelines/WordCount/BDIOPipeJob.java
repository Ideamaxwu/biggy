package edu.helpal.datar.gbiggy.pipelines.WordCount;

/**
 * 
 * BDIO Pipe Job for WordCount
 *
 */
public class BDIOPipeJob {
	public void submit(){
		System.out.println("submitting WordCount input job on bdio...");
		System.out.println("  innner Loooooooooooooooo");
		BDIOPipeJobReadFile bpjr = new BDIOPipeJobReadFile();
		
		bpjr.startReadFile();
		
		System.out.println("  innner ooooooooooooooooG");
	}
}
