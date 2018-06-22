package edu.helpal.datar.gbiggy.pipelines.pipes;

import edu.helpal.datar.gbiggy.framework.pipeline.ComputationPipe;
import edu.helpal.datar.gbiggy.pipelines.jobs.SparkPipeJob;

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
