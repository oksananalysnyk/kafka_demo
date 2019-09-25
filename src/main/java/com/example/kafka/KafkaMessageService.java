package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageService {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${kafka.topic.name}")
    private String topicName;

    @Autowired
    public KafkaMessageService(
            KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    void sendMessage(String msg) {
        kafkaTemplate.send(topicName, msg);
    }

}
