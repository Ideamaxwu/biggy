package edu.helpal.datar.biggy.engines.input.Flafka;

import edu.helpal.datar.biggy.engines.input.IInputEngine;

/**
 * 
 * InputEngine Flafka
 *
 */
public class InputEngineFlafka implements IInputEngine{

	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup InputEngine Flafka.");
		
		//KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic);
        //producerThread.start();
        //KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
        //consumerThread.start();
	}

}
