package edu.helpal.datar.gbiggy.framework.pipeline;

import edu.helpal.datar.gbiggy.framework.datamodel.BigData;

/**
 * 
 * Pipeline
 *
 */
public class Pipeline {
	private AbstractPipe getPipeline(){
		
		AbstractPipe headPipe = new HeadPipe(AbstractPipe.HEAD);
		AbstractPipe controlPipe = new ControlPipe(AbstractPipe.CONTROL, "data contorl is pre config.");
		AbstractPipe inputPipe = new InputPipe(AbstractPipe.INPUT, "data feed from HDFS.");
		AbstractPipe storagePipe = new StoragePipe(AbstractPipe.STORAGE, "data storage in HBase.");
		AbstractPipe computationPipe = new ComputationPipe(AbstractPipe.COMPUTATION, "data analysis by Spark.");
		AbstractPipe outputPipe = new OutputPipe(AbstractPipe.OUTPUT, "data visulization by D3.");
		
		headPipe.setNextPipe(controlPipe);
		controlPipe.setNextPipe(inputPipe);
		inputPipe.setNextPipe(storagePipe);
		storagePipe.setNextPipe(computationPipe);
		computationPipe.setNextPipe(outputPipe);
		
		return headPipe;
	}
	public void run(){
		System.out.println("Your pipeJob on your own BDMS Pipeline:");
		AbstractPipe pipeline = getPipeline();
		pipeline.pipeStart(AbstractPipe.HEAD, "DBWordCount pipeline starting.", new BigData(null));
	}
}
