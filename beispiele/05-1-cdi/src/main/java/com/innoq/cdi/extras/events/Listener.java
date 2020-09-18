package com.innoq.cdi.extras.events;

import javax.enterprise.event.Observes;

public class Listener {
    public void listen(@Observes MyEvent evt) {
        System.err.println("Received: " + evt);
    }
}
