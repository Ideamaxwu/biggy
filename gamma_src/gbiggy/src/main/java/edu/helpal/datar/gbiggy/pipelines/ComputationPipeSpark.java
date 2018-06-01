package edu.helpal.datar.gbiggy.pipelines;

import edu.helpal.datar.gbiggy.framework.pipeline.ComputationPipe;
import edu.helpal.datar.gbiggy.pipelines.WordCount.SparkPipeJob;

/**
 * 
 * Computation Pipe Spark
 *
 */
public class ComputationPipeSpark extends ComputationPipe{

	public ComputationPipeSpark(int level, String pipeJob) {
		super(level, pipeJob);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void start(String message){
		super.start(message);
		SparkPipeJob sparkpj = new SparkPipeJob();
		sparkpj.submit();
	}

}
