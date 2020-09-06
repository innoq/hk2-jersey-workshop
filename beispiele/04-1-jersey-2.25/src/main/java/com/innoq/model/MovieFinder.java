package com.innoq.model;

import java.util.stream.Stream;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface MovieFinder {
    Stream<Movie> findAll();
}
