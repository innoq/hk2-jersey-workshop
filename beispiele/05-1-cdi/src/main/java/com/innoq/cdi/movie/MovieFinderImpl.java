package com.innoq.cdi.movie;

import java.util.stream.Stream;

public class MovieFinderImpl implements MovieFinder {
    @Override
    public Stream<Movie> findAll() {
        return Stream.of(new Movie("The Godfather", "Francis Ford Coppola"),
                new Movie("2001: A Space Odyssey", "Stanley Kubrick"));
    }
}
