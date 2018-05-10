package edu.helpal.datar.biggy.framework.pipeline;

/**
 * 
 * Pipeline
 *
 */
public class Pipeline {
	private static AbstractPipe getPipeline(){
		
		AbstractPipe headPipe = new HeadPipe(AbstractPipe.HEAD);
		AbstractPipe inputPipe = new InputPipe(AbstractPipe.INPUT);
		AbstractPipe storagePipe = new StoragePipe(AbstractPipe.STORAGE);
		AbstractPipe outputPipe = new OutputPipe(AbstractPipe.OUTPUT);
		
		headPipe.setNextPipe(inputPipe);
		inputPipe.setNextPipe(storagePipe);
		storagePipe.setNextPipe(outputPipe);
		
		return headPipe;
	}
	public void run(){
		System.out.println("Your own BDMS Pipeline:");
		AbstractPipe pipeline = getPipeline();
		pipeline.pipeStart(AbstractPipe.HEAD, "pipeline starting.");
	}
}
