package edu.helpal.datar.gbiggy.pipelines.WordCount;

import java.io.IOException;

/**
 * 
 * D3 Pipe Job for WordCount
 *
 */
public class D3PipeJob {
	public void submit(){
		System.out.println("submitting WordCount output job on d3...");
		System.out.println("  inner Loooooooooooooooo");
		D3PipeJobVisual dpjv = new D3PipeJobVisual();
		try {
			dpjv.startVisualPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("  innner ooooooooooooooooG");
	}
}
