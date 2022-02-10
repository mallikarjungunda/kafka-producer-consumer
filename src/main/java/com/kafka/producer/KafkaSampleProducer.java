package com.kafka.producer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import com.kafka.constants.KafkaConstants;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaSampleProducer {

    static Logger log = LoggerFactory.getLogger(KafkaSampleProducer.class);

    public static void main(String[] args) {
        runProducer();
    }

    static void runProducer() {
        Producer<Long, String> producer = createProducer();

        for (int index = 0; index < KafkaConstants.MESSAGE_COUNT; index++) {
            ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(KafkaConstants.TOPIC_NAME,
                    "This is record " + index);
            try {
                RecordMetadata metadata = producer.send(record).get();
                //log.info("Record sent with key " + index + " to partition " + metadata.partition() +
                 //       " with offset " + metadata.offset());
                System.out.println("Record sent with key " + index + " to partition " + metadata.partition() +
                        " with offset " + metadata.offset());
            } catch (ExecutionException e) {
                log.error("Error in sending record", e);
                e.printStackTrace();
            } catch (InterruptedException e) {
                log.error("Error in sending record", e);
                e.printStackTrace();
            }
        }
    }

    public static Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, KafkaConstants.CLIENT_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class.getName());
        return new KafkaProducer<>(props);
    }
}
