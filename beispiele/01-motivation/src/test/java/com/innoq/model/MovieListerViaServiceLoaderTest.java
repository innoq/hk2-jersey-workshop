package com.innoq.model;

public class MovieListerViaServiceLoaderTest extends AbstractMovieListerTest {

    @Override
    protected MovieLister lister() { return new MovieListerViaServiceLoader(); }

}
