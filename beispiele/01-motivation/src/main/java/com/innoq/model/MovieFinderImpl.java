package com.innoq.model;

import java.util.stream.Stream;

public class MovieFinderImpl implements MovieFinder {
    static {
        ServiceRegistry.register(MovieFinder.class, MovieFinderImpl.class);
    }

    @Override
    public Stream<Movie> findAll() {
        return Stream.of(new Movie("The Godfather", "Francis Ford Coppola"),
                         new Movie("2001: A Space Odyssey", "Stanley Kubrick"));
    }
}
