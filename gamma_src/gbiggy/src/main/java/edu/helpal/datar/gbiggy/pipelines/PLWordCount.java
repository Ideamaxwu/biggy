package edu.helpal.datar.gbiggy.pipelines;

import edu.helpal.datar.gbiggy.framework.pipeline.AbstractPipe;
import edu.helpal.datar.gbiggy.framework.pipeline.HeadPipe;
import edu.helpal.datar.gbiggy.framework.pipeline.Pipeline;

/**
 * 
 * Pipeline WordCount
 *
 */
public class PLWordCount extends Pipeline{
	private AbstractPipe getPLWordCount(){
		AbstractPipe headPipe = new HeadPipe(AbstractPipe.HEAD);
		AbstractPipe hbaseStoragePipe = new StoragePipeHBase(AbstractPipe.STORAGE, "data storage by HBase Pipe.");
		AbstractPipe sparkComputationPipe = new ComputationPipeSpark(AbstractPipe.COMPUTATION, "data computation by Spark Pipe.");
		AbstractPipe d3OutputPipe = new OutputPipeD3(AbstractPipe.OUTPUT, "data output by D3 Pipe.");
		
		headPipe.setNextPipe(hbaseStoragePipe);
		hbaseStoragePipe.setNextPipe(sparkComputationPipe);
		sparkComputationPipe.setNextPipe(d3OutputPipe);
		
		return headPipe;
	}
	
	public void run(){
		System.out.println("Your WordCount Pipeline on your own BDMS Pipeline:");
		AbstractPipe pipeline = getPLWordCount();
		pipeline.pipeStart(AbstractPipe.HEAD, "WordCount pipeline starting.");
	}
}
