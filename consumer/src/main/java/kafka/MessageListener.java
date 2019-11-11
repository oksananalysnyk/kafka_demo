package kafka;

import kafka.config.KafkaConsumerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.topic.group}")
    public void listen(String message) {
        System.out.println("Received Messasge: " + message);
    }
}
