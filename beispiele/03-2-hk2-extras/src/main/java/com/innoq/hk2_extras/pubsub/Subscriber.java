package com.innoq.hk2_extras.pubsub;

import org.glassfish.hk2.api.messaging.MessageReceiver;
import org.glassfish.hk2.api.messaging.SubscribeTo;
import org.jvnet.hk2.annotations.Service;

@Service
@MessageReceiver
public class Subscriber {

    public void receive(@SubscribeTo EventPayload payload) {
        System.err.println("Received: " + payload.getMessage());
    }

}
