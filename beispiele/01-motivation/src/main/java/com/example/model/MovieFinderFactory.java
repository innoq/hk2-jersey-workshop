package com.example.model;

public class MovieFinderFactory {
    private static final MovieFinderFactory INSTANCE = new MovieFinderFactory();
    public MovieFinder newMovieFinder() {
        return new MovieFinderImpl();
    }
    public static MovieFinderFactory getInstance() {
        return INSTANCE;
    }
}
