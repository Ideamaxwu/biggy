package edu.helpal.datar.biggy.engines.input.Flafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerAPI extends Thread{
	private final Producer<String, String> producer;
    private final String topic;
    private final Properties props;
    public KafkaProducerAPI(String topic)
    {
    	props = new Properties();  
        props.put("bootstrap.servers", KafkaProperties.kafkaServerURL+":"+KafkaProperties.kafkaServerPort);  
        props.put("acks", "all");  
        props.put("retries", 0);  
        props.put("batch.size", 16384);  
        props.put("linger.ms", 1);  
        props.put("buffer.memory", KafkaProperties.kafkaProducerBufferSize);  
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");  
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
        producer = new KafkaProducer<String, String>(props);
        this.topic = topic;
    }
    @Override
    public void run() {
        int messageNo = 1;
        while (true)
        {
            String messageStr = new String("Message_" + messageNo);
            System.out.println("Send:" + messageStr);
            producer.send(new ProducerRecord<String, String>(topic, "msg> " + messageStr)); 
            messageNo++;
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
