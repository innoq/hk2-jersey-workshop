package com.innoq.model;

public class MovieListerViaServiceRegistry extends MovieLister {

    public MovieListerViaServiceRegistry() {
        super(ServiceRegistry.get(MovieFinder.class));
    }
}
