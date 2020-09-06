package com.innoq.model;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class MovieLister {
    private final MovieFinder movieFinder;

    @Inject
    public MovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
    
    public List<Movie> findByDirector(String director) {
        return movieFinder.findAll()
            .filter(m -> director.equals(m.getDirector()))
            .collect(Collectors.toList());
    }
}
