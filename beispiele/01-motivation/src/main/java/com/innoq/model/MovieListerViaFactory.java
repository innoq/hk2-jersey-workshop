package com.innoq.model;

public class MovieListerViaFactory extends MovieLister {
    public MovieListerViaFactory() {
        super(MovieFinderFactory.getInstance().newMovieFinder());
    }
}
