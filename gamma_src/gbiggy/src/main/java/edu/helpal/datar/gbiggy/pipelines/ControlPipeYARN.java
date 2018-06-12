package edu.helpal.datar.gbiggy.pipelines;

import edu.helpal.datar.gbiggy.framework.pipeline.ControlPipe;
import edu.helpal.datar.gbiggy.pipelines.WordCount.YARNPipeJob;

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
