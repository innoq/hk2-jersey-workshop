package com.example.model;

public class MovieListerViaFactoryTest extends AbstractMovieListerTest {

    @Override
    protected MovieLister lister() { return new MovieListerViaFactory(); }

}
