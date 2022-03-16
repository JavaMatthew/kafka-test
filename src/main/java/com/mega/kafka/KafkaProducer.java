package com.mega.kafka;

import java.time.LocalDateTime;
import java.util.Properties;

import com.alibaba.fastjson.JSONObject;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.utils.Json;

public class KafkaProducer extends Thread{

	private final String topic;
	private final int count;

	public KafkaProducer(String topic, int count) {
		this.topic = topic;
		this.count = count;
	}
	
	public void producer() {
		Properties props = new Properties();
        props.put("zk.connect", KafkaConfig.ZOOKEEPER);
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", KafkaConfig.KAFKA);
        props.put("request.required.acks", "1");
        props.put("num.partitions", "3");
        props.put("linger.ms", "0");
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(config);
        for (int i = 0; i < count; i++) {
        	String now = LocalDateTime.now().toString();
            JSONObject json = new JSONObject();
            json.put("now", now);
            producer.send(new KeyedMessage<String, String>(topic, String.valueOf(i), json.toJSONString()));
            System.out.println("KAFKA PRODUCER:" + now);
        }
        producer.close();
        System.out.println("PRODUCER COMPLETE");
	}
	
	public void run() {
        System.out.println("run");
		producer();
	}
}
