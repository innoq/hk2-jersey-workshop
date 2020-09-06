package com.innoq;

import com.innoq.model.*;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.internal.inject.AbstractBinder;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        packages("com.innoq");
        register(new AbstractBinder() {
                @Override
                protected void configure() {
                    bind(MovieFinderImpl.class)
                        .to(MovieFinder.class);
                    bind(MovieLister.class)
                        .to(MovieLister.class);
                }
            });
    }
}
