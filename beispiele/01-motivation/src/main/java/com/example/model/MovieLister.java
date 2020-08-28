package com.example.model;

import java.util.List;
import java.util.stream.Collectors;

public class MovieLister {
    private final MovieFinder movieFinder;

    protected MovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
    
    public List<Movie> findByDirector(String director) {
        return movieFinder.findAll()
            .filter(m -> director.equals(m.getDirector()))
            .collect(Collectors.toList());
    }
}
