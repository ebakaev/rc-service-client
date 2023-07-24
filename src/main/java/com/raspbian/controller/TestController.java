package com.raspbian.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${client.id:default}")
    String clientId;

    @GetMapping("/hello")
    public String hello() {
        logger.debug("Test passed! Good start! \nClient ID: {}", "Raspbian client 1.1.0");
        return "Test passed! Good start! </br>Client ID: " + clientId;
    }

}
