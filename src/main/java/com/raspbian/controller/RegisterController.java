package com.raspbian.controller;

import com.raspbian.service.RootServerService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Register current client into remote Kafka.
 */
@RestController
@RequiredArgsConstructor
@Data
public class RegisterController {

    @Value("${client.id}")
    String clientId;

    @Value("${client.version}")
    String clientVersion;

    @Value("${client.description}")
    String clientDescription;

    @Value("${client.company}")
    String clientCompany;

    @Value("${remote.server.address}")
    String remoteSystem;

    @Autowired
    RootServerService serverService;

    @GetMapping("/clientInfo")
    public String getClientInfo() {
        return this.toString();
    }

    @PostMapping("/register")
    public String registerClient() {
        //register kafka topic via remote server
        ResponseEntity<String> response = serverService.registerClient(clientId, clientVersion, clientDescription, clientCompany);

        if (response.getStatusCode().value() == 200) {
            if (response.getBody().contains("error")) {
                return getClientId() + " registering failed with message: " + response.getBody().replace("error", "");
            } else {
                return getClientId() + " registered in remote system: " + getRemoteSystem();
            }
        } else {
            return getClientId() + " failed to registere in remote system: " + getRemoteSystem() + ". Please contact system administrator...";
        }
    }

}
