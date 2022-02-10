package com.kafka.constants;

public class KafkaConstants {

    public static String KAFKA_BROKERS = "localhost:9092";

    public static Integer MESSAGE_COUNT=100;

    public static String CLIENT_ID="client1";

    public static String TOPIC_NAME="kafka-message-count-topic";

    public static String GROUP_ID_CONFIG="consumerGroup1";

    public static String GROUP_ID_CONFIG_2 ="consumerGroup2";

    public static Integer MAX_NO_MESSAGE_FOUND_COUNT=100;

    public static String OFFSET_RESET_LATEST="latest";

    public static String OFFSET_RESET_EARLIER="earliest";

    public static Integer MAX_POLL_RECORDS=1;
}