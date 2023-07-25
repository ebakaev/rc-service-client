package com.raspbian.service;

import org.springframework.stereotype.Service;

@Service
public class CommandService {

    public void checkController() {
        System.out.println("Checking controller is alive?...");
    }

    public void startController() {
        System.out.println("Start command to controller...");
    }

    public void stopController() {
        System.out.println("Stop command to controller...");
    }

}
