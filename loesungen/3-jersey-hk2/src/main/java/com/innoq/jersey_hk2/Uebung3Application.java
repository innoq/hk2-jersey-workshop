package com.innoq.jersey_hk2;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class Uebung3Application extends ResourceConfig {
    public Uebung3Application() {
        packages("com.innoq.jersey_hk2");
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                addActiveDescriptor(MyServiceImpl.class);
            }
        });
    }
}
