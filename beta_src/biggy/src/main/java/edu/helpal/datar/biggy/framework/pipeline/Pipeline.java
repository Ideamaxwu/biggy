package edu.helpal.datar.biggy.framework.pipeline;

/**
 * 
 * Pipeline
 *
 */
public class Pipeline {
	private static AbstractPipe getPipeline(){
		AbstractPipe inputPipe = new InputPipe(AbstractPipe.INPUT);
		AbstractPipe storagePipe = new StoragePipe(AbstractPipe.STORAGE);
		AbstractPipe outputPipe = new OutputPipe(AbstractPipe.OUTPUT);
		
		outputPipe.setNextPipe(storagePipe);
		storagePipe.setNextPipe(inputPipe);
		
		return outputPipe;
	}
	public void run(){
		System.out.println("Your own BDMS Pipeline:");
		AbstractPipe pipeline = getPipeline();
	}
}
