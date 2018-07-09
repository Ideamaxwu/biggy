package com.helpal.datar.rbiggy.pipelines.pipes;

import com.helpal.datar.rbiggy.framework.pipeline.ComputationPipe;
import com.helpal.datar.rbiggy.pipelines.jobs.SparkPipeJob;

/**
 * 
 * Computation Pipe Spark
 *
 */
public class ComputationPipeSpark extends ComputationPipe{
	String cls;
	public ComputationPipeSpark(int level, String pipeJob, String cls) {
		super(level, pipeJob);
		// TODO Auto-generated constructor stub
		this.cls = cls;
	}
	
	@Override
	protected void start(String message){
		super.start(message);
		SparkPipeJob sparkpj = new SparkPipeJob();
		sparkpj.submit(this.bigdata, this.cls);
	}

}
