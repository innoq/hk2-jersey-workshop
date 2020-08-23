package com.innoq.jersey_requestscope.domain;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class MovieSearcherImpl implements MovieSearcher {
    private final MovieFinder movieFinder;

    @Inject
    public MovieSearcherImpl(final MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    @Override
    public List<Movie> findByDirector(String director) {
        return movieFinder.findAll()
            .filter(m -> director.equals(m.getDirector()))
            .collect(Collectors.toList());
    }
}
