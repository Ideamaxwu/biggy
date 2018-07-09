package com.helpal.datar.rbiggy.pipelines.pipes;

import com.helpal.datar.rbiggy.framework.pipeline.OutputPipe;
import com.helpal.datar.rbiggy.pipelines.jobs.D3PipeJob;

/**
 * 
 * Output Pipe D3
 *
 */
public class OutputPipeD3 extends OutputPipe{
	String cls;
	public OutputPipeD3(int level, String pipeJob, String cls) {
		super(level, pipeJob);
		// TODO Auto-generated constructor stub
		this.cls = cls;
	}
	
	@Override
	protected void start(String message){
		super.start(message);
		D3PipeJob d3pj = new D3PipeJob();
		d3pj.submit(this.bigdata, this.cls);
	}

}
