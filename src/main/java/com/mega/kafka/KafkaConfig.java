package com.mega.kafka;

public class KafkaConfig {

	public static final String ZOOKEEPER_ES = "172.16.50.35:2181,172.16.50.203:2181,172.16.50.197:2181";
	public static final String KAFKA_ES = "172.16.50.35:9092,172.16.50.203:9092,172.16.50.197:9092";
	
	public static final String ZOOKEEPER_OL = "172.16.50.224:2181,172.16.50.223:2181,172.16.50.225:2181";
	public static final String KAFKA_OL = "172.16.50.224:9092,172.16.50.223:9092,172.16.50.225:9092";
	
	public static final String ZOOKEEPER_DEV = "47.96.30.119:9993";
	public static final String KAFKA_DEV = "47.96.30.119:9992";
	
	public static String ZOOKEEPER = ZOOKEEPER_DEV;
	public static String KAFKA = KAFKA_DEV;
	
//	public static final String TOPIC = "test-kafka";
//	public static final String TOPIC = "werewolf-web-activity-prod-log";
//	public static final String TOPIC = "werewolf-web-activity-coder-log";
	public static final String TOPIC = "werewolf-web-activity-beta-log";

	
}
