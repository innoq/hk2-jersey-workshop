package com.innoq.cdi.movie;

import java.util.stream.Stream;

public interface MovieFinder {
    Stream<Movie> findAll();
}
