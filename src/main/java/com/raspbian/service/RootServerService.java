package com.raspbian.service;

import com.raspbian.model.RegisterRequest;
import com.raspbian.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RootServerService {

    public static final String SERVER_REGISTER_CONTEXT_PATH = "/server/register";

    @Value("${remote.server.address}")
    String serverUrl;

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String> registerClient(String clientId, String clientVersion, String clientDescription, String companyName) {
        RegisterRequest request = RegisterRequest.builder()
                .clientId(clientId)
                .companyName(companyName)
                .clientVersion(clientVersion)
                .clientDescription(clientDescription)
                .status(Status.ONLINE.getStatus())
                .build();
        return restTemplate.postForEntity(serverUrl + SERVER_REGISTER_CONTEXT_PATH, request, String.class);
    }

}
