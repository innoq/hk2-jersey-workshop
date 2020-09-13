package com.innoq.hk2_extras.pubsub;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.extras.ExtrasUtilities;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

public class PubSubMain {
    public static void main(String[] args) {
        ServiceLocator locator = ServiceLocatorFactory.getInstance().create("operation");
        ServiceLocatorUtilities.addClasses(locator, Publisher.class, Subscriber.class);
        ExtrasUtilities.enableTopicDistribution(locator);

        Publisher pub = locator.getService(Publisher.class);
        pub.send("Hallo Welt!");

        locator.getService(Subscriber.class);
        pub.send("Hallo Welt, zweiter Versuch!");

    }
}
