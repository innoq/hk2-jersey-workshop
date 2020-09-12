package com.innoq.model;

public class MovieListerViaNewTest extends AbstractMovieListerTest {
    @Override
    protected MovieLister lister() {
        return new MovieLister(new MovieFinderImpl());
    }
}
