package edu.helpal.datar.gbiggy.pipelines;

import edu.helpal.datar.gbiggy.framework.pipeline.InputPipe;
import edu.helpal.datar.gbiggy.pipelines.WordCount.BDIOPipeJob;

/**
 * 
 * Input Pipe BDIO
 *
 */
public class InputPipeBDIO extends InputPipe{

	public InputPipeBDIO(int level, String pipeJob) {
		super(level, pipeJob);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void start(String message){
		super.start(message);
		BDIOPipeJob bdiopj = new BDIOPipeJob();
		bdiopj.submit();
	}

}
