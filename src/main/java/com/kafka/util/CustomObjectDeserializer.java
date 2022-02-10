package com.kafka.util;

import java.util.Map;

import com.kafka.model.MessageModel;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectDeserializer implements Deserializer<MessageModel> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public MessageModel deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        MessageModel object = null;
        try {
            object = mapper.readValue(data, MessageModel.class);
        } catch (Exception exception) {
            System.out.println("Error in deserializing bytes "+ exception);
        }
        return object;
    }

    @Override
    public void close() {
    }

}
