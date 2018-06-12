package edu.helpal.datar.gbiggy.pipelines.WordCount;

import java.io.IOException;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

/**
 * 
 * D3 Pipe Job for WordCount
 *
 */
public class D3PipeJob {
	public void submit(BigData bigdata){
		System.out.println("submitting WordCount output job on d3...");
		System.out.println("  inner Loooooooooooooooo");
		D3PipeJobVisual dpjv = new D3PipeJobVisual();
		try {
			dpjv.startVisualPage(bigdata);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("  innner ooooooooooooooooG");
	}
}
