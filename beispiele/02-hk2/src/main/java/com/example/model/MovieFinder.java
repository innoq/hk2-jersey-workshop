package com.example.model;

import java.util.stream.Stream;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface MovieFinder {
    Stream<Movie> findAll();
}
