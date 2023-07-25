package com.raspbian.listener;

import com.raspbian.model.Command;
import com.raspbian.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @Autowired
    CommandService commandService;

    @KafkaListener(topics = "${client.id}", groupId = "groupId")
    void listener(String data) {
        try {
            switch (Command.valueOf(data.toUpperCase())) {
                case START:
                    System.out.println("Run START command...");
                    commandService.startController();
                    break;
                case STOP:
                    System.out.println("Run STOP command...");
                    commandService.stopController();
                    break;
                case CHECK:
                    System.out.println("Run CHECK command...");
                    commandService.checkController();
                    break;
                default:
                    System.out.println(data + " command not supported!");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(data + " command not supported!");
        }

    }
}
