package edu.helpal.datar.biggy.engines.input.Flafka;

import edu.helpal.datar.biggy.engines.input.IInputEngine;

/**
 * 
 * InputEngine Flafka
 * start Kafka instance before run job
 * bin\windows\kafka-server-start.bat    config\server.properties
 * the versions must be compatible among Kafka, ZooKeeper, Scala, etc.
 *
 */
public class InputEngineFlafka implements IInputEngine{

	@Override
	public void setup() {
		//TODO setup
		System.out.println("setup InputEngine Flafka.");
		
		KafkaProducerAPI producerThread = new KafkaProducerAPI(KafkaProperties.topic);
        producerThread.start();
        KafkaConsumerAPI consumerThread = new KafkaConsumerAPI(KafkaProperties.topic);
        consumerThread.start();
	}

}
