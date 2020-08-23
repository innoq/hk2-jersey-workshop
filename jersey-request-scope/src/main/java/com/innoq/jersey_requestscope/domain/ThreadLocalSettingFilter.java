package com.innoq.jersey_requestscope.domain;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.glassfish.hk2.api.Factory;

@Provider
public class ThreadLocalSettingFilter
    implements ContainerRequestFilter, ContainerResponseFilter {

    private static final String MOVIE_FINDER_PROP = "movieFinder";

    private final Factory<MovieFinder> movieFinderFactory;

    @Inject
    public ThreadLocalSettingFilter(final Factory<MovieFinder> movieFinderFactory) {
        this.movieFinderFactory = movieFinderFactory;
    }

    @Override
    public void filter(ContainerRequestContext req) {
        req.setProperty(MOVIE_FINDER_PROP, movieFinderFactory.provide());
    }

    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext res) {
        final Object f = req.getProperty(MOVIE_FINDER_PROP);
        if (f != null) {
            movieFinderFactory.dispose((MovieFinder) f);
        }
    }
}
