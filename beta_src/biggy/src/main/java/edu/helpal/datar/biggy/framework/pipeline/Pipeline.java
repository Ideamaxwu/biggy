package edu.helpal.datar.biggy.framework.pipeline;

/**
 * 
 * Pipeline
 *
 */
public class Pipeline {
	private static AbstractPipe getPipeline(){
		
		AbstractPipe outputPipe = new OutputPipe(AbstractPipe.OUTPUT);
		AbstractPipe storagePipe = new StoragePipe(AbstractPipe.STORAGE);
		AbstractPipe inputPipe = new InputPipe(AbstractPipe.INPUT);
		
		outputPipe.setNextPipe(storagePipe);
		storagePipe.setNextPipe(inputPipe);
		
		return outputPipe;
	}
	public void run(){
		System.out.println("Your own BDMS Pipeline:");
		AbstractPipe pipeline = getPipeline();
		pipeline.pipeMessage(AbstractPipe.INPUT, "This is Input Pipe.");
		pipeline.pipeMessage(AbstractPipe.STORAGE, "This is Storage Pipe.");
		pipeline.pipeMessage(AbstractPipe.OUTPUT, "This is Output Pipe.");
	}
}
