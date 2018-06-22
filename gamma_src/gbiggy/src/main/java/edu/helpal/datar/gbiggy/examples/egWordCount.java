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
 * WordCount example
 * 
 */

public class egWordCount {
	
	public void run(){
		System.out.println("->->->   Example WordCount   <-<-<-");
		System.out.println("Your WordCount Pipeline on BigData DataFlow runs on your own BDMS ConfChain!");
		BigData bigdata = new BigData("egWordCount");
		AbstractPipe pipeline = getWordCount();
		pipeline.pipeStart(AbstractPipe.HEAD, "egWordCount pipeline starting.", bigdata);
	}
	
	private AbstractPipe getWordCount(){
		AbstractPipe headPipe = new HeadPipe(AbstractPipe.HEAD);
		AbstractPipe yarnControlPipe = new ControlPipeYARN(AbstractPipe.CONTROL, "data control by YARN Pipe.");
		AbstractPipe fileInputPipe = new InputPipeBDIO(AbstractPipe.INPUT, "data input by BDIO Pipe.", "edu.helpal.datar.gbiggy.examples.WordCount.egBDIOPipeJobReadFile");
		AbstractPipe hbaseStoragePipe = new StoragePipeHBase(AbstractPipe.STORAGE, "data storage by HBase Pipe.", "edu.helpal.datar.gbiggy.examples.WordCount.egHBasePipeJobWriteDB");
		AbstractPipe sparkComputationPipe = new ComputationPipeSpark(AbstractPipe.COMPUTATION, "data computation by Spark Pipe.", "edu.helpal.datar.gbiggy.examples.WordCount.egSparkPipeJobWordCount");
		AbstractPipe d3OutputPipe = new OutputPipeD3(AbstractPipe.OUTPUT, "data output by D3 Pipe.", "edu.helpal.datar.gbiggy.examples.WordCount.egD3PipeJobVisual");
		
		headPipe.setNextPipe(yarnControlPipe);
		yarnControlPipe.setNextPipe(fileInputPipe);
		fileInputPipe.setNextPipe(hbaseStoragePipe);
		hbaseStoragePipe.setNextPipe(sparkComputationPipe);
		sparkComputationPipe.setNextPipe(d3OutputPipe);
		
		return headPipe;
	}
}
