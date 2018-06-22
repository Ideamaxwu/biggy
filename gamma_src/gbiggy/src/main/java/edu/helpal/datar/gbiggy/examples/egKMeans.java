package edu.helpal.datar.gbiggy.examples;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;
import edu.helpal.datar.gbiggy.framework.pipeline.AbstractPipe;
import edu.helpal.datar.gbiggy.framework.pipeline.HeadPipe;
import edu.helpal.datar.gbiggy.pipelines.pipes.ComputationPipeSpark;
import edu.helpal.datar.gbiggy.pipelines.pipes.ControlPipeYARN;
import edu.helpal.datar.gbiggy.pipelines.pipes.InputPipeBDIO;
import edu.helpal.datar.gbiggy.pipelines.pipes.OutputPipeD3;
import edu.helpal.datar.gbiggy.pipelines.pipes.StoragePipeHBase;

/*
 * 
 * K means example
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
		AbstractPipe fileInputPipe = new InputPipeBDIO(AbstractPipe.INPUT, "data input by BDIO Pipe.", "edu.helpal.datar.gbiggy.examples.KMeans.egBDIOPipeJobReadFile");
		AbstractPipe hbaseStoragePipe = new StoragePipeHBase(AbstractPipe.STORAGE, "data storage by HBase Pipe.", "edu.helpal.datar.gbiggy.examples.KMeans.egHBasePipeJobWriteDB");
		AbstractPipe sparkComputationPipe = new ComputationPipeSpark(AbstractPipe.COMPUTATION, "data computation by Spark Pipe.", "edu.helpal.datar.gbiggy.examples.KMeans.egSparkPipeJobCluster");
		AbstractPipe d3OutputPipe = new OutputPipeD3(AbstractPipe.OUTPUT, "data output by D3 Pipe.", "edu.helpal.datar.gbiggy.examples.KMeans.egD3PipeJobVisual");
		
		headPipe.setNextPipe(yarnControlPipe);
		yarnControlPipe.setNextPipe(fileInputPipe);
		fileInputPipe.setNextPipe(hbaseStoragePipe);
		hbaseStoragePipe.setNextPipe(sparkComputationPipe);
		sparkComputationPipe.setNextPipe(d3OutputPipe);
		
		return headPipe;
	}
}
