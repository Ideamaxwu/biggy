package edu.helpal.datar.biggy.engines.input.Flafka;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerAPI extends Thread {
	private final Consumer<String, String> consumer;
	private final String topic;
	private final Properties props;

	public KafkaConsumerAPI(String topic) {
		props = new Properties();
		props.put("bootstrap.servers", KafkaProperties.kafkaServerURL + ":" + KafkaProperties.kafkaServerPort);
		props.put("zookeeper.connect", KafkaProperties.zkConnect);
		props.put("group.id", KafkaProperties.groupId);
		props.put("zookeeper.session.timeout.ms", KafkaProperties.connectionTimeOut);
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", KafkaProperties.reconnectInterval);
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		consumer = new KafkaConsumer<String, String>(props);
		this.topic = topic;
	}

	public void run() {
		consumer.subscribe(Collections.singletonList(topic));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(1000);
			records.forEach(record -> {
				System.out.println("Receive: " + record.value());
			});
		}
	}
}
