package com.innoq.jersey_requestscope.domain;

import javax.ws.rs.core.Context;

import org.glassfish.grizzly.http.server.Request;
import org.glassfish.hk2.api.Factory;

public class MovieFinderFactory implements Factory<MovieFinder> {

    @Override
    public MovieFinder provide() {
        final MovieFinder f = new MovieFinderImpl();
        System.err.println("Providing " + f);
        return f;
    }

    @Override
    public void dispose(MovieFinder finder) {
        finder.done();
    }
}
