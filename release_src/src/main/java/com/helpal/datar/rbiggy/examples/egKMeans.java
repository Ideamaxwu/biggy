package com.helpal.datar.rbiggy.examples;

import com.helpal.datar.rbiggy.framework.datamodel.BigData;
import com.helpal.datar.rbiggy.framework.pipeline.AbstractPipe;
import com.helpal.datar.rbiggy.framework.pipeline.HeadPipe;
import com.helpal.datar.rbiggy.pipelines.pipes.ComputationPipeSpark;
import com.helpal.datar.rbiggy.pipelines.pipes.ControlPipeYARN;
import com.helpal.datar.rbiggy.pipelines.pipes.InputPipeBDIO;
import com.helpal.datar.rbiggy.pipelines.pipes.OutputPipeD3;
import com.helpal.datar.rbiggy.pipelines.pipes.StoragePipeHBase;

/**
 * 
 * KMeans example
 * 
 */

public class egKMeans {
	
	public void run(){
		System.out.println("->->->   Example KMeans   <-<-<-");
		System.out.println("Your KMeans Pipeline on BigData DataFlow runs on your own BDMS ConfChain!");
		BigData bigdata = new BigData("egKMeans");
		AbstractPipe pipeline = getKMeans();
		pipeline.pipeStart(AbstractPipe.HEAD, "egKMeans pipeline starting.", bigdata);
	}
	
	private AbstractPipe getKMeans(){
		AbstractPipe headPipe = new HeadPipe(AbstractPipe.HEAD);
		AbstractPipe yarnControlPipe = new ControlPipeYARN(AbstractPipe.CONTROL, "data control by YARN Pipe.");
		AbstractPipe fileInputPipe = new InputPipeBDIO(AbstractPipe.INPUT, "data input by BDIO Pipe.", "com.helpal.datar.rbiggy.examples.KMeans.egBDIOPipeJobReadFile");
		AbstractPipe hbaseStoragePipe = new StoragePipeHBase(AbstractPipe.STORAGE, "data storage by HBase Pipe.", "com.helpal.datar.rbiggy.examples.KMeans.egHBasePipeJobWriteDB");
		AbstractPipe sparkComputationPipe = new ComputationPipeSpark(AbstractPipe.COMPUTATION, "data computation by Spark Pipe.", "com.helpal.datar.rbiggy.examples.KMeans.egSparkPipeJobCluster");
		AbstractPipe d3OutputPipe = new OutputPipeD3(AbstractPipe.OUTPUT, "data output by D3 Pipe.", "com.helpal.datar.rbiggy.examples.KMeans.egD3PipeJobVisual");
		
		headPipe.setNextPipe(yarnControlPipe);
		yarnControlPipe.setNextPipe(fileInputPipe);
		fileInputPipe.setNextPipe(hbaseStoragePipe);
		hbaseStoragePipe.setNextPipe(sparkComputationPipe);
		sparkComputationPipe.setNextPipe(d3OutputPipe);
		
		return headPipe;
	}
}
