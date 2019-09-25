package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProducerController {

    private KafkaMessageService messageService;

    @Autowired
    public ProducerController(KafkaMessageService messageService) {

        this.messageService = messageService;
    }

    @PostMapping("/message")
    public ResponseEntity<Object> publishMessage() {

        messageService.sendMessage("hello");
        return ResponseEntity.ok().build();

    }

}
