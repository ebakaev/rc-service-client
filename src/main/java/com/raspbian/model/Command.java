package com.raspbian.model;

public enum Command {

    START("START"),
    STOP("STOP"),
    CHECK("CHECK");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

}
