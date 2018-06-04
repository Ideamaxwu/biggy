package edu.helpal.datar.gbiggy.pipelines.WordCount;

import java.io.IOException;

/**
 * 
 * Spark Pipe Job for WordCount
 *
 */
public class D3PipeJob {
	public void submit(){
		System.out.println("submitting WordCount output job on d3...");
		D3PipeJobVisual dpjv = new D3PipeJobVisual();
		try {
			dpjv.startVisualPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
