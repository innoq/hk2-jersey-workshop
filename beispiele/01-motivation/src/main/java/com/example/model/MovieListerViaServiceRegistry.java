package com.example.model;

public class MovieListerViaServiceRegistry extends MovieLister {

    public MovieListerViaServiceRegistry() {
        super(ServiceRegistry.get(MovieFinder.class));
    }
}
