package edu.helpal.datar.biggy.engines.output.D3;

import java.io.IOException;

import edu.helpal.datar.biggy.engines.output.IOutputEngine;
import edu.helpal.datar.biggy.engines.output.D3.demo.WebVisual;

/**
 * 
 * OutputEngine D3
 *
 */
public class OutputEngineD3 implements IOutputEngine{

	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup OutputEngine D3.");
		start();
	}
	
	public void start() {
		WebVisual whp = new WebVisual();
		try {
			whp.startWebPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
