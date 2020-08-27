package com.example.model;

import java.util.stream.Stream;

public interface MovieFinder {
    Stream<Movie> findAll();
}
