package com.helpal.datar.rbiggy.pipelines.pipes;

import com.helpal.datar.rbiggy.framework.pipeline.StoragePipe;
import com.helpal.datar.rbiggy.pipelines.jobs.HBasePipeJob;

/**
 * 
 * Storage Pipe HBase
 *
 */
public class StoragePipeHBase extends StoragePipe{
	String cls;
	public StoragePipeHBase(int level, String pipeJob, String cls) {
		super(level, pipeJob);
		// TODO Auto-generated constructor stub
		this.cls = cls;
	}
	
	@Override
	protected void start(String message){
		super.start(message);
		HBasePipeJob hbasepj = new HBasePipeJob();
		hbasepj.submit(this.bigdata, this.cls);
	}

}
