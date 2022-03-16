package com.mega.kafka;

public class KafkaMain {

	public static void main(String[] args) {
		int role = 0;
		int type = 0;
		int count = 10000000;
		if (args.length > 0) {
			role = Integer.valueOf(args[0]);
		}
		if (args.length > 1) {
			type = Integer.valueOf(args[1]);
		}
		if (args.length > 2) {
			count = Integer.valueOf(args[2]);
		}
		if (type == 1) {
			KafkaConfig.ZOOKEEPER = KafkaConfig.ZOOKEEPER_OL;
			KafkaConfig.KAFKA = KafkaConfig.KAFKA_OL;
		}
		
		System.out.println("ZOOKEEPER::" + KafkaConfig.ZOOKEEPER);
		System.out.println("KAFKA::" + KafkaConfig.KAFKA);
		System.out.println("TOPIC::" + KafkaConfig.TOPIC);
		
		System.out.println("===START===");
		KafkaProducer producerThread = new KafkaProducer(KafkaConfig.TOPIC, count);
		producerThread.start();
		/*if (role == 0) {
			KafkaProducer producerThread = new KafkaProducer(KafkaConfig.TOPIC, count);
			producerThread.start();
		} else {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			KafkaConsumer consumerThread = new KafkaConsumer(KafkaConfig.TOPIC);
			consumerThread.start();
		}*/
	}
}
