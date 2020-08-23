package com.innoq.jersey_requestscope.domain;

import javax.ws.rs.core.Context;

import org.glassfish.grizzly.http.server.Request;
import org.glassfish.hk2.api.Factory;

public class ThreadLocalMovieFinderFactory implements Factory<MovieFinder> {

    private static final ThreadLocal<MovieFinder> MOVIE_FINDER = new ThreadLocal<MovieFinder>() {
        @Override
        public MovieFinder initialValue() {
            return new MovieFinderImpl();
        }
    };

    @Override
    public MovieFinder provide() {
        final MovieFinder f = MOVIE_FINDER.get();
        System.err.println("Providing " + f);
        return f;
    }

    @Override
    public void dispose(MovieFinder finder) {
        finder.done();
        if (finder == MOVIE_FINDER.get()) {
            System.err.println("Removing " + finder);
            MOVIE_FINDER.remove();
        }
    }
}
