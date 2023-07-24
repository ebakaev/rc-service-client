package com.raspbian.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    String clientId;
    String companyName;
    String clientDescription;
    String status;
    String clientVersion;
}
