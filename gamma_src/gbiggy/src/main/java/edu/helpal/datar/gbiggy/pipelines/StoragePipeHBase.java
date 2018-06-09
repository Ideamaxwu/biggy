package edu.helpal.datar.gbiggy.pipelines;

import edu.helpal.datar.gbiggy.framework.pipeline.StoragePipe;
import edu.helpal.datar.gbiggy.pipelines.WordCount.HBasePipeJob;

/**
 * 
 * Storage Pipe HBase
 *
 */
public class StoragePipeHBase extends StoragePipe{

	public StoragePipeHBase(int level, String pipeJob) {
		super(level, pipeJob);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void start(String message){
		super.start(message);
		HBasePipeJob hbasepj = new HBasePipeJob();
		hbasepj.submit();
	}

}
