package com.example.model;

public class MovieListerViaServiceRegistryTest extends AbstractMovieListerTest {

    @Override
    protected MovieLister lister() {
        try {
            Class.forName("com.example.model.MovieFinderImpl");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return new MovieListerViaServiceRegistry();
    }

}
