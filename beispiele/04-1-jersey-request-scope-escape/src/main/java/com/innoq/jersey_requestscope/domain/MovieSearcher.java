package com.innoq.jersey_requestscope.domain;

import java.util.List;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface MovieSearcher {
    List<Movie> findByDirector(String director);
}
