package com.example;

import com.example.model.*;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.internal.inject.AbstractBinder;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        packages("com.example");
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
