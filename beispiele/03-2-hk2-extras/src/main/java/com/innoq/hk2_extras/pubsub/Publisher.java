package com.innoq.hk2_extras.pubsub;

import org.glassfish.hk2.api.messaging.Topic;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class Publisher {
    private final Topic<EventPayload> topic;

    @Inject
    public Publisher(Topic<EventPayload> topic) {
        this.topic = topic;
    }

    public void send(String message) {
        topic.publish(new EventPayload(message));
    }
}
