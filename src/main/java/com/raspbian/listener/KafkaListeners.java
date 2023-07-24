package com.raspbian.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "${client.id}", groupId = "groupId")
    void listener(String data) {
        System.out.println("Message from kafka: " + data);
    }
}
