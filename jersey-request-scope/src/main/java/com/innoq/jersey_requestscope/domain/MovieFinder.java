package com.innoq.jersey_requestscope.domain;

import java.util.stream.Stream;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface MovieFinder {
    Stream<Movie> findAll();
}
