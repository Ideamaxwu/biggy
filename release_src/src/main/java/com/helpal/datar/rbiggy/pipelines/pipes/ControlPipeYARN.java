package com.helpal.datar.rbiggy.pipelines.pipes;

import com.helpal.datar.rbiggy.framework.pipeline.ControlPipe;
import com.helpal.datar.rbiggy.pipelines.jobs.YARNPipeJob;

/**
 * 
 * Control Pipe YARN
 *
 */
public class ControlPipeYARN extends ControlPipe{

	public ControlPipeYARN(int level, String pipeJob) {
		super(level, pipeJob);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void start(String message){
		super.start(message);
		YARNPipeJob yarnpj = new YARNPipeJob();
		yarnpj.submit(this.bigdata);
	}

}
