package com.innoq.hk2_extras.pubsub;

public class EventPayload {
    private final String message;

    public EventPayload(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
