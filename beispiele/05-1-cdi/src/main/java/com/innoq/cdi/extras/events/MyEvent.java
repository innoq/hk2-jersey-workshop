package com.innoq.cdi.extras.events;

public class MyEvent {
    private final String message;

    public MyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
