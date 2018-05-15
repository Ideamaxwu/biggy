package edu.helpal.datar.biggy.engines.input.Flafka;

public interface KafkaProperties {
	final static String zkConnect = "localhost:2181";
    final static String groupId = "group_demo";
    final static String topic = "KafkaDemo";
    final static String kafkaServerURL = "localhost";
    final static int kafkaServerPort = 9092;
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 40000;
    final static int reconnectInterval = 1000;
}
