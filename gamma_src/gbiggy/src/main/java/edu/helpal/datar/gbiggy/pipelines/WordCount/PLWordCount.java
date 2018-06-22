package edu.helpal.datar.gbiggy.pipelines.WordCount;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;
import edu.helpal.datar.gbiggy.framework.pipeline.AbstractPipe;
import edu.helpal.datar.gbiggy.framework.pipeline.HeadPipe;
import edu.helpal.datar.gbiggy.framework.pipeline.Pipeline;
import edu.helpal.datar.gbiggy.pipelines.pipes.ComputationPipeSpark;
import edu.helpal.datar.gbiggy.pipelines.pipes.ControlPipeYARN;
import edu.helpal.datar.gbiggy.pipelines.pipes.InputPipeBDIO;
import edu.helpal.datar.gbiggy.pipelines.pipes.OutputPipeD3;
import edu.helpal.datar.gbiggy.pipelines.pipes.StoragePipeHBase;

/**
 * 
 * Pipeline WordCount
 *
 */
public class PLWordCount extends Pipeline{
	private AbstractPipe getPLWordCount(){
		AbstractPipe headPipe = new HeadPipe(AbstractPipe.HEAD);
		AbstractPipe yarnControlPipe = new ControlPipeYARN(AbstractPipe.CONTROL, "data control by YARN Pipe.");
		AbstractPipe fileInputPipe = new InputPipeBDIO(AbstractPipe.INPUT, "data input by BDIO Pipe.", "edu.helpal.datar.gbiggy.pipelines.WordCount.BDIOPipeJobReadFile");
		AbstractPipe hbaseStoragePipe = new StoragePipeHBase(AbstractPipe.STORAGE, "data storage by HBase Pipe.", "edu.helpal.datar.gbiggy.pipelines.WordCount.HBasePipeJobWriteDB");
		AbstractPipe sparkComputationPipe = new ComputationPipeSpark(AbstractPipe.COMPUTATION, "data computation by Spark Pipe.", "edu.helpal.datar.gbiggy.pipelines.WordCount.SparkPipeJobWordCount");
		AbstractPipe d3OutputPipe = new OutputPipeD3(AbstractPipe.OUTPUT, "data output by D3 Pipe.", "edu.helpal.datar.gbiggy.pipelines.WordCount.D3PipeJobVisual");
		
		headPipe.setNextPipe(yarnControlPipe);
		yarnControlPipe.setNextPipe(fileInputPipe);
		fileInputPipe.setNextPipe(hbaseStoragePipe);
		hbaseStoragePipe.setNextPipe(sparkComputationPipe);
		sparkComputationPipe.setNextPipe(d3OutputPipe);
		
		return headPipe;
	}
	
	public void run(){
		System.out.println("Your WordCount Pipeline on BigData DataFlow runs on your own BDMS ConfChain!");
		BigData bigdata = new BigData("WordCount");
		AbstractPipe pipeline = getPLWordCount();
		pipeline.pipeStart(AbstractPipe.HEAD, "WordCount pipeline starting.", bigdata);
	}
}
