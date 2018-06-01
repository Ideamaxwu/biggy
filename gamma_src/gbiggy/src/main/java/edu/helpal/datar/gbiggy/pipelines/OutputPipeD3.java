package edu.helpal.datar.gbiggy.pipelines;

import edu.helpal.datar.gbiggy.framework.pipeline.OutputPipe;
import edu.helpal.datar.gbiggy.pipelines.WordCount.D3PipeJob;

/**
 * 
 * Output Pipe D3
 *
 */
public class OutputPipeD3 extends OutputPipe{

	public OutputPipeD3(int level, String pipeJob) {
		super(level, pipeJob);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void start(String message){
		super.start(message);
		D3PipeJob d3pj = new D3PipeJob();
		d3pj.submit();
	}

}
