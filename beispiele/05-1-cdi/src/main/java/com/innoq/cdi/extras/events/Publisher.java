package com.innoq.cdi.extras.events;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class Publisher {
    @Inject
    private Event<MyEvent> myEvent;

    public void fire() {
        myEvent.fire(new MyEvent("Hello"));
    }
}
