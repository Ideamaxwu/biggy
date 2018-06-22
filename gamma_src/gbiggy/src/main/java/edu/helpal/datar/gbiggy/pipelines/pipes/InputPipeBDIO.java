package edu.helpal.datar.gbiggy.pipelines.pipes;

import edu.helpal.datar.gbiggy.framework.pipeline.InputPipe;
import edu.helpal.datar.gbiggy.pipelines.jobs.BDIOPipeJob;

/**
 * 
 * Input Pipe BDIO
 *
 */
public class InputPipeBDIO extends InputPipe{
	String cls;
	public InputPipeBDIO(int level, String pipeJob, String cls) {
		super(level, pipeJob);
		// TODO Auto-generated constructor stub
		this.cls = cls;
	}
	
	@Override
	protected void start(String message){
		super.start(message);
		BDIOPipeJob bdiopj = new BDIOPipeJob();
		bdiopj.submit(this.bigdata, this.cls);
	}

}
